package com.barbosa.desafio_picpay.service;

import com.barbosa.desafio_picpay.dto.TransacaoDTO;
import com.barbosa.desafio_picpay.infrastructure.entity.Carteira;
import com.barbosa.desafio_picpay.infrastructure.entity.TipoUsuario;
import com.barbosa.desafio_picpay.infrastructure.entity.Transacao;
import com.barbosa.desafio_picpay.infrastructure.entity.Usuario;
import com.barbosa.desafio_picpay.infrastructure.exceptions.BadRequestExeption;
import com.barbosa.desafio_picpay.infrastructure.exceptions.MerchantCannotTransferException;
import com.barbosa.desafio_picpay.infrastructure.repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final UsuarioService usuarioService;
    private final CarteiraService carteiraService;
    private final AutorizacaoService autorizacaoService;
    private final NotificacaoService notificacaoService;
    private final TransacaoRepository transacaoRepository;


    @Transactional
    public void transferirValor(TransacaoDTO transacaoDTO){
        // buscar dados dos usuarios para verificação se não é um lojista que está fazendo a transferencia
        Usuario pagador = usuarioService.buscarUsuario(transacaoDTO.payer());
        Usuario recebedor = usuarioService.buscarUsuario(transacaoDTO.peyee());

        // valida se é um lojista que está fazendo a tranferencia
        validaPagadorLojista(pagador);

        // validar o saldo do usuario que está fazendo a tranferencia
        validarSaldoUsuario(pagador, transacaoDTO.value());

        // chama api de autorização
        validarTransferencia();

        // subtrai da carteira do pagador o valor enviado
        pagador.getCarteira().setSaldo(pagador.getCarteira().getSaldo().subtract(transacaoDTO.value()));

        // salva essa carteira no banco de dados
        atualizarCarteira(pagador.getCarteira());

        // adiciona a carteira do usuario o valor recebido
        recebedor.getCarteira().setSaldo(recebedor.getCarteira().getSaldo().add(transacaoDTO.value()));
        atualizarCarteira(recebedor.getCarteira());

        Transacao transacao = Transacao.builder()
                .valor(transacaoDTO.value())
                .recebedor(recebedor)
                .pagador(pagador)
                .build();

        transacaoRepository.save(transacao);

        enviarNotificao();



    }

    private void validaPagadorLojista(Usuario usuario){
        try{
            if(usuario.getTipoUsuario().equals(TipoUsuario.LOJISTA)){
                throw new MerchantCannotTransferException
                        ("Operação não autorizada: logistas não podem realizar transferências");
            }
        } catch (MerchantCannotTransferException e) {
            throw new MerchantCannotTransferException(e.getMessage());
        }
    }

    private void validarSaldoUsuario(Usuario usuario, BigDecimal valor){
        try{
            if(usuario.getCarteira().getSaldo().compareTo(valor) < 0){
                throw new IllegalArgumentException("Transação não autorizada, saldo insulficiente");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validarTransferencia() {
        try{
            if(!autorizacaoService.validarTransferencia()) {
                throw new IllegalArgumentException("Transação não autorizada pela API");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Transação não autorizada pela API");
        }
    }

    private void atualizarCarteira(Carteira carteira) {
        carteiraService.salvar(carteira);
    }

    private void enviarNotificao(){
        try{
            notificacaoService.enviarNotificacao();
        } catch (Exception e) {
            throw new BadRequestExeption("Erro ao enviar notificação");
        }
    }


}

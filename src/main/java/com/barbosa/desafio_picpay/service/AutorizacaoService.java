package com.barbosa.desafio_picpay.service;

import com.barbosa.desafio_picpay.dto.AutorizacaoDTO;
import com.barbosa.desafio_picpay.infrastructure.clients.AutorizacaoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutorizacaoService {

    private final AutorizacaoClient autorizacaoClient;

    public boolean validarTransferencia(){
        AutorizacaoDTO autorizacao = autorizacaoClient.validarAutorizacao();
        return autorizacao.data().authorization();
    }

}

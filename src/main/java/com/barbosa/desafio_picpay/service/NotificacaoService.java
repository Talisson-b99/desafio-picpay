package com.barbosa.desafio_picpay.service;

import com.barbosa.desafio_picpay.infrastructure.clients.NotificacaoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final NotificacaoClient notificacaoClient;

    public void enviarNotificacao(){
        notificacaoClient.enviarNotificacao();
    }
}

package com.barbosa.desafio_picpay.infrastructure.clients;

import com.barbosa.desafio_picpay.dto.AutorizacaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "Autorizacao-client",
        url = "https://util.devi.tools/api/v2/authorize"
)
public interface AutorizacaoClient {

    @GetMapping
    public AutorizacaoDTO validarAutorizacao();
}

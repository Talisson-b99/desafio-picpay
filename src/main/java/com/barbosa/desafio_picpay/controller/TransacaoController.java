package com.barbosa.desafio_picpay.controller;

import com.barbosa.desafio_picpay.dto.TransacaoDTO;
import com.barbosa.desafio_picpay.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping("/transfer")
    public ResponseEntity<Void> relizarTransacao(@RequestBody TransacaoDTO transacaoDTO){
        transacaoService.transferirValor(transacaoDTO);

       return ResponseEntity.accepted().build();

    }
}

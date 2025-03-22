package com.barbosa.desafio_picpay.service;

import com.barbosa.desafio_picpay.infrastructure.entity.Carteira;
import com.barbosa.desafio_picpay.infrastructure.repository.CarteiraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarteiraService {

    private final CarteiraRepository carteiraRepository;

    public void salvar(Carteira carteira){
        carteiraRepository.save(carteira);
    }

}

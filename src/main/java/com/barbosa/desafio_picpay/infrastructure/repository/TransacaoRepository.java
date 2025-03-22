package com.barbosa.desafio_picpay.infrastructure.repository;

import com.barbosa.desafio_picpay.infrastructure.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}

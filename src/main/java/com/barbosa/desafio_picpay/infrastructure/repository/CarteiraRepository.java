package com.barbosa.desafio_picpay.infrastructure.repository;

import com.barbosa.desafio_picpay.infrastructure.entity.Carteira;
import com.barbosa.desafio_picpay.infrastructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}

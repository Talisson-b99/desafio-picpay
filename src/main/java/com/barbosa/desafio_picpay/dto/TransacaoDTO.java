package com.barbosa.desafio_picpay.dto;

import java.math.BigDecimal;

public record TransacaoDTO(BigDecimal value, Long payer, Long peyee) {
}

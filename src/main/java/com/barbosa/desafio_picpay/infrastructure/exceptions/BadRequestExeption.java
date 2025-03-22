package com.barbosa.desafio_picpay.infrastructure.exceptions;

public class BadRequestExeption extends RuntimeException {
    public BadRequestExeption(String message) {
        super(message);
    }
}

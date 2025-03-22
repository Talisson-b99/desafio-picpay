package com.barbosa.desafio_picpay.infrastructure.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String mensagem){
        super(mensagem);
    }
}

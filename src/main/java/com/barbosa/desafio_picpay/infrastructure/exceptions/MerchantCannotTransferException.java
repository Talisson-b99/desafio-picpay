package com.barbosa.desafio_picpay.infrastructure.exceptions;

public class MerchantCannotTransferException extends RuntimeException{
    public MerchantCannotTransferException(String mensagem){
        super(mensagem);
    }
}

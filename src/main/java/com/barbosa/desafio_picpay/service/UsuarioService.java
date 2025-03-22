package com.barbosa.desafio_picpay.service;

import com.barbosa.desafio_picpay.infrastructure.entity.Usuario;
import com.barbosa.desafio_picpay.infrastructure.exceptions.UserNotFoundException;
import com.barbosa.desafio_picpay.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario buscarUsuario(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
    }
}

package com.picpaysimplificado.service;

import com.picpaysimplificado.domain.Usuario;
import com.picpaysimplificado.exception.NegocioException;
import com.picpaysimplificado.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrarUsuario(Usuario usuario) throws NegocioException {
        usuario.validar();
        List<String> erros = new ArrayList<>();
        if (usuarioRepository.existsByCpf(usuario.getCpf())) {
            erros.add("Já existe um usuário cadastrado com este CPF.");
        }
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            erros.add("Já existe um usuário cadastrado com este e-mail.");
        }
        if (erros.isEmpty()) {
           usuarioRepository.save(usuario);
        } else {
            throw new NegocioException(erros);
        }
    }

}

package com.picpaysimplificado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picpaysimplificado.domain.Usuario;
import com.picpaysimplificado.repository.UsuarioRepository;


@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios")
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
}

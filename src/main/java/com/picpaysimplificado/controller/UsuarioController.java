package com.picpaysimplificado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.picpaysimplificado.domain.Usuario;
import com.picpaysimplificado.exception.NegocioException;
import com.picpaysimplificado.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public List<Usuario> listar() {
		return service.listar();
	}
	
	@GetMapping("/{usuarioId}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long usuarioId) {
		return service.buscar(usuarioId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionar( @RequestBody Usuario usuario) throws NegocioException {
		 service.cadastrarUsuario(usuario);
	}
	
	@PutMapping("/{usuarioId}")
	public ResponseEntity<Usuario> alterar(@PathVariable Long usuarioId, 
			@RequestBody Usuario usuario){
		return service.alterar(usuarioId, usuario);
	}
	
	@DeleteMapping("/{usuarioId}")
	public ResponseEntity<Void> remover(@PathVariable Long usuarioId){
		return service.remover(usuarioId);
	}
}

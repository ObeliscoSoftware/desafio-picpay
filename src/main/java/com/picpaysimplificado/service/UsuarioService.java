package com.picpaysimplificado.service;

import com.picpaysimplificado.domain.Usuario;
import com.picpaysimplificado.exception.NegocioException;
import com.picpaysimplificado.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listar(){
    	return usuarioRepository.findAll();
    }
    public ResponseEntity<Usuario> buscar(Long usuarioId){
    	return usuarioRepository.findById(usuarioId)
		.map(ResponseEntity::ok)
		.orElse(ResponseEntity.notFound().build());
    }
    
    @Transactional
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
    
    @Transactional
    public ResponseEntity<Usuario> alterar(Long idUsuario, Usuario usuario){
    	if(!usuarioRepository.existsById(idUsuario)) {
			return ResponseEntity.notFound().build();
		}
		usuario.setId(idUsuario);
		return ResponseEntity.ok(usuarioRepository.save(usuario));
    }
    
    @Transactional
    public ResponseEntity<Void> remover(Long usuarioId){
    	if(!usuarioRepository.existsById(usuarioId)) {
			return ResponseEntity.notFound().build();
		}
		usuarioRepository.deleteById(usuarioId);
		return ResponseEntity.noContent().build();
    }
    

}

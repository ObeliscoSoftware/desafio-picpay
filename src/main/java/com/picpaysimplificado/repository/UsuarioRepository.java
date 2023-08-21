package com.picpaysimplificado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.picpaysimplificado.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

   boolean existsByCpf(String cpf);

   boolean existsByEmail(String email);

}

package com.picpaysimplificado.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.picpaysimplificado.enums.TipoUsuario;

import com.picpaysimplificado.exception.NegocioException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.validation.Validator;
import util.ValidateUtil;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(unique = true)
	private String cpf;
	
	@Column(unique = true)
	private String email;
	
	private String senha;

	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;
	
	private BigDecimal saldo;
	
	
	public Usuario() {
	}

	public Usuario(Long id, String nome, String cpf, String email, String senha, TipoUsuario tipoUsuario,
			BigDecimal saldo) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	
	public void validar() throws NegocioException {
		List<String> erros = new ArrayList<>();
		if (ValidateUtil.isEmpty(nome)) {
			erros.add("O usuário deve ter o nome preenchido.");
		}
		if (ValidateUtil.isEmpty(cpf)) {
			erros.add("O usuário deve ter o CPF preenchido.");
		}
		if (ValidateUtil.isEmpty(email)) {
			erros.add("O usuário deve ter o e-mail preenchido.");
		}
		if (ValidateUtil.isEmpty(senha)) {
			erros.add("O usuário deve ter a senha preenchida.");
		}
		if (tipoUsuario == null) {
			erros.add("O usuário deve ter o tipo preenchido.");
		}
		if (!erros.isEmpty()) {
			throw new NegocioException(erros);
		}
	}

}

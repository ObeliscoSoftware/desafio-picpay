package com.picpaysimplificado.enums;

public enum TipoUsuario {
	COMUM(1),
	LOJISTA(2);
	
	private final int codigo;
	
	private TipoUsuario(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	
}

package com.picpaysimplificado.exception;

import java.util.ArrayList;
import java.util.List;

public class NegocioException extends Exception {

    private List<String> mensagens;

    public NegocioException(List<String> mensagens) {
        this.mensagens = mensagens;
    }

    public List<String> getMensagens() {
        return mensagens;
    }

	@Override
	public String toString() {
		return "NegocioException [mensagens=" + mensagens + "]";
	}
    
}

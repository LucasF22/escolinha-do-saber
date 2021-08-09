package br.com.qm.Escolinha.exception;

public class EscolinhaException extends Exception{

	private static final long serialVersionUID = 4226286023895905130L;
	
	private String mensagemDeErro;
	
	public EscolinhaException(String mensagemDeErro) {
		this.mensagemDeErro = mensagemDeErro;
	}
	
	public String getMensagemDeErro() {
		return mensagemDeErro;
	}
}

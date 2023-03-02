package com.edge.restapi.excepciones;


public class CustomerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8101964167105055928L;
	
	private Long numeroId;

	private String emailResponsable;

	public CustomerException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	public String getEmailResponsable() {
		return emailResponsable;
	}

	public void setEmailResponsable(String emailResponsable) {
		this.emailResponsable = emailResponsable;
	}

	public Long getNumeroId() {
		return numeroId;
	}

	public void setNumeroId(Long numeroId) {
		this.numeroId = numeroId;
	}
	
}

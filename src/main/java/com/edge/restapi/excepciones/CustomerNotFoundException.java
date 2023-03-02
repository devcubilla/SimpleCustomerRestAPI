package com.edge.restapi.excepciones;

public class CustomerNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4676277382765368087L;

	public CustomerNotFoundException(long customerID){
		super("Could not find customer " + customerID);
	}
}

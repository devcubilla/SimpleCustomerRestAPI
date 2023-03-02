package com.edge.restapi.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends Person{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8876913705281704521L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long customerID;
	private String email;
	
	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [ CustomerID="+ getCustomerID() + " CI="+ getCedulaIdentidad()+ " Nombre="+ getNombre() 
		+ " Apellido="+ getApellido() + " Edad="+ getEdad() + " Email="+ getEmail() + " ]";
	}
	
}

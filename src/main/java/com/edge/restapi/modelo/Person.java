package com.edge.restapi.modelo;

import java.io.Serializable;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cedulaIdentidad;
	private String nombre;
	private String apellido;
	private Integer edad;
	public String getCedulaIdentidad() {
		return cedulaIdentidad;
	}
	public void setCedulaIdentidad(String cedulaIdentidad) {
		this.cedulaIdentidad = cedulaIdentidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
}

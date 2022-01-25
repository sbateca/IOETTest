package com.ioet.model;

import java.util.List;

/**
 * Esta clase representa una entidad Empleado junto con sus datos representativos (nombre y lista de Bloques).
 * También implementa métodos que permiten el acceso y modificación de sus variables.
 * @author Sergio Bateca
 * @version 1.0
 */
public class Empleado {

	private String nombre;
	private List<Bloque> listaBloques;
	
	
	// Constructor de la clase

	public Empleado(String nombre, List<Bloque> listaBloques) {
		this.nombre = nombre;
		this.listaBloques = listaBloques;
	}
	
	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Bloque> getListaBloques() {
		return listaBloques;
	}

	public void setListaBloques(List<Bloque> listaBloques) {
		this.listaBloques = listaBloques;
	}
	
}

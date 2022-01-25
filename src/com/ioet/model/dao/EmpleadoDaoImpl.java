package com.ioet.model.dao;

import java.util.List;

import com.ioet.model.Bloque;
import com.ioet.model.Empleado;


/**
 * Clase que implementa la lógica de las transacciones definidas en la interfaz IEmpleadoDao
 * @author Sergio Bateca
 */
public class EmpleadoDaoImpl implements IEmpleadoDao{
	
	
	public EmpleadoDaoImpl() {}

	@Override
	public Empleado crearEmpleado(String nombre, List<Bloque> listaBloques) {
		return new Empleado(nombre, listaBloques);
	}

}

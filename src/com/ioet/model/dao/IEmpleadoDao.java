package com.ioet.model.dao;

import java.util.List;

import com.ioet.model.Bloque;
import com.ioet.model.Empleado;

/**
 * Interfaz que define los métodos a ser implementados para realizar transacciones para los empleados
 * @author Sergio Bateca
 *
 */
public interface IEmpleadoDao {

	public Empleado crearEmpleado(String nombre, List<Bloque> listaBloques);
	
}

package com.ioet.service;

import java.util.List;

import com.ioet.model.Bloque;
import com.ioet.model.Empleado;


/**
 * La interfaz IEmpleadoService define servicios que se van a proveer para empleados
 * @author Sergio Bateca
 *
 */
public interface IEmpleadoService {
	
	public Empleado crearEmpleado(String nombre, List<Bloque> listaBloques);
}

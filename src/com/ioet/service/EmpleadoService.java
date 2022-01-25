package com.ioet.service;

import java.util.List;

import com.ioet.model.Bloque;
import com.ioet.model.Empleado;
import com.ioet.model.dao.EmpleadoDaoImpl;
import com.ioet.model.dao.IEmpleadoDao;


/**
 * Clase que implementa los servicios a proveer para los empleados
 * @author Sergio Bateca
 *
 */
public class EmpleadoService implements IEmpleadoService{
	
	
	IEmpleadoDao iEmpleadoDao = new EmpleadoDaoImpl();
	
	public EmpleadoService() {}

	@Override
	public Empleado crearEmpleado(String nombre, List<Bloque> listaBloques) {
		return iEmpleadoDao.crearEmpleado(nombre, listaBloques);
	}

}

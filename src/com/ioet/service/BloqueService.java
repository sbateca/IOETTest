package com.ioet.service;


import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;

import com.ioet.model.Bloque;
import com.ioet.model.dao.IBloqueDao;


/**
 * Clase que implementa los servicios a proveer para los bloques
 * @author Sergio Bateca
 *
 */
public class BloqueService implements IBloqueService{

	
	
	public BloqueService() {
	}
	
	
	IBloqueDao iBloqueDao;

	@Override
	public Bloque agregarBloque(TemporalAccessor diaSemana, LocalTime horaIngreso, LocalTime horaSalida) {
		return iBloqueDao.crearBloque(diaSemana, horaIngreso, horaSalida);
	}



	

	
	
}

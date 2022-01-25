package com.ioet.model.dao;


import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;

import com.ioet.model.Bloque;


/**
 * Clase que implementa la lógica de las transacciones definidas en la interfaz IBloqueDao
 * @author Sergio Bateca
 */
public class BloqueDaoImpl implements IBloqueDao{
	
	

	
	public BloqueDaoImpl() {
	}
	
	
	@Override
	public Bloque crearBloque(TemporalAccessor diaSemana, LocalTime horaInicio, LocalTime horaFin) {
		return new Bloque(diaSemana, horaInicio, horaFin);
	}

}

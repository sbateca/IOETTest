package com.ioet.model.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;

import com.ioet.model.Bloque;
import com.ioet.model.Empleado;



/**
 * Interfaz que define los métodos a ser implementados para realizar transacciones para los bloques
 * @author Sergio Bateca
 *
 */
public interface IBloqueDao {
	
	public Bloque crearBloque(TemporalAccessor diaSemana, LocalTime horaInicio, LocalTime horaFin);
	
}

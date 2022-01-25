package com.ioet.service;

import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;

import com.ioet.model.Bloque;

/**
 * La interfaz IBloqueService define servicios que se van a proveer para los bloques
 * @author Sergio Bateca
 *
 */
public interface IBloqueService {

	public Bloque agregarBloque(TemporalAccessor diaSemana, LocalTime horaIngreso, LocalTime horaSalida);
}

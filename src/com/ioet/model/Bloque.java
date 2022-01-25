package com.ioet.model;



import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;

/**
 * Esta clase representa una entidad Bloque el cual est� definido por
 * el d�a de la semana, hora de ingreso y hora de salida.
 * Incluye tambi�n los m�todos para el acceso y establecimiento de datos de las variables
 * @author Sergio Bateca
 * @version 1.0
 */
public class Bloque {

	private TemporalAccessor diaSemana;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	
	
	// Constructor de la clase
	
	public Bloque(TemporalAccessor diaSemana, LocalTime horaInicio, LocalTime horaFin) {
		this.diaSemana = diaSemana;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	
	
	// Getters y Setters
	
	public TemporalAccessor getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(TemporalAccessor diaSemana) {
		this.diaSemana = diaSemana;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalTime getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}
}

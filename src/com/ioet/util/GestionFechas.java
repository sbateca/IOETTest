package com.ioet.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;


/**
 * Esta clase implementa métodos que permiten realizar operaciones con fechas y horas.
 * @author Sergio Bateca
 *
 */
public class GestionFechas {

	
	
	/**
	 * Método que extrae un TemporalAccesor de acuerdo con la cadena de texto recibida
	 * @param diaSemana que corresponde a una cadena de texto que indica el día de la semana
	 * @return TemporalAccesor correspondiente al día de la semana
	 */
	public TemporalAccessor extraerTemporalDiaSemana(String diaSemana) {
		
		
		String diaSemanaAjustado = "";
		
		switch (diaSemana.toLowerCase()) {
			case "su":
			diaSemanaAjustado = "Sun";
			break;
			
			case "mo":
				diaSemanaAjustado = "Mon";
			break;
			
			case "tu":
				diaSemanaAjustado = "Tue";
			break;
			
			case "we":
				diaSemanaAjustado = "Wed";
			break;
			
			case "th":
				diaSemanaAjustado = "Thu";
			break;
			
			case "fr":
				diaSemanaAjustado = "Fri";
			break;
			
			case "sa":
				diaSemanaAjustado = "Sat";
			break;

			
		}
		
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("EEE",Locale.US);
		TemporalAccessor temporalAccesor = formateador.parse(diaSemanaAjustado);
		
		return temporalAccesor;
	}
	
	
	
	/**
	 * Método que obtiene una hora (LocalTime) de acuerdo al texto recibido como parámetro
	 * @param hora
	 * @return
	 */
	public LocalTime obtenerHoraString(String hora){
		
		DateTimeFormatter formateadorHora = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime localtime = LocalTime.parse(hora,formateadorHora);
		
		return localtime;
	}
	
	
	
}

package com.ioet.controller;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import com.ioet.model.Bloque;
import com.ioet.model.Empleado;
import com.ioet.service.EmpleadoService;
import com.ioet.service.IEmpleadoService;
import com.ioet.util.GestionFichero;




/**
 * La clase EmpleadoController implementa la lógica de la aplicación. Extrae el contenido de un archivo plano
 * y determina los cruces de los bloque de los empleados.
 * @author Sergio Bateca
 */
public class EmpleadoController {

	
	/**
	 * Método principal de la aplicación. Utiliza las funciones que extraen información del fichero 
	 * y determina el cruce de bloques
	 * @param args
	 * @author Sergio Bateca
	 */
	public static void main(String[] args) {
		
		GestionFichero gestionFichero = new GestionFichero();
		IEmpleadoService iEmpleadoService = new EmpleadoService();
		List<Empleado> listaEmpleados = new ArrayList<>();
		
		
		List<String> lineasFichero = gestionFichero.extraerTextoFichero("C:\\input.txt");
		
		for(String linea: lineasFichero) {
			
			String nombre = gestionFichero.extraerNombreLineaTexto(linea);
			List<Bloque> listaBloques = gestionFichero.generaBloquesLineaTexto(linea);
			listaEmpleados.add(iEmpleadoService.crearEmpleado(nombre, listaBloques));
		}
		
		
		List<String> listaResultado = extraerBloquesDeterminarCruce(listaEmpleados);
		listaResultado.forEach(System.out::println);

	}
	
	
	
	
	/**
	 * Este método realiza la iteración de la lista de empleados para seleccionar dos de ellos
	 * y de esta manera utilizar el método que determina los cruces entre bloques.
	 * @param listaEmpleados lista de empleados
	 * @return lista con los resultados de cada comparación de pares de empleados
	 */
	public static List<String> extraerBloquesDeterminarCruce(List<Empleado> listaEmpleados) {
		
		List<String> resultadoProceso = new ArrayList<>();

		
		for(int i=0; i< listaEmpleados.size()-1;i++) {
			
			for (int j = i+1; j < listaEmpleados.size(); j++) {
				
				Empleado empleado1 = listaEmpleados.get(i);
				Empleado empleado2 = listaEmpleados.get(j);
				
				
				String res = determinarCrucesBloques(empleado1, empleado2);
				
				if( res != "") resultadoProceso.add(res);			
				
			}
				
		}
		
		return resultadoProceso;
	}
	
	
	
	
	
	
	
	/**
	 * Método que determina el cruce de bloques (horarios) de dos empleados
	 * @param empleado1 corresponde al primer empleado a revisar
	 * @param empleado2 corresponde al segundo empleado a revisar
	 * @return String con el formato "nombreEmpleado1 - nombreEmpleado2: cantidad de bloques que se cruzan" 
	 */
	public static String determinarCrucesBloques(Empleado empleado1, Empleado empleado2) {
		
		
		List<Bloque> bloquesEmpleado1 = empleado1.getListaBloques();
		List<Bloque> bloquesEmpleado2 = empleado2.getListaBloques();
		
		String resultado = "";
		int contadorCruces = 0;
		
		for (int i = 0; i < bloquesEmpleado1.size(); i++) {
			
			for (int j = 0; j < bloquesEmpleado2.size(); j++) {
				
				Bloque bloqueEmp1 = bloquesEmpleado1.get(i);
				Bloque bloqueEmp2 = bloquesEmpleado2.get(j);
				
				if(DayOfWeek.from(  bloqueEmp1.getDiaSemana()  )
						.equals(  DayOfWeek.from(bloqueEmp2.getDiaSemana())  ) ) {
					
					if(		(bloqueEmp1.getHoraInicio().compareTo(bloqueEmp2.getHoraFin()) == -1 ||
							bloqueEmp1.getHoraInicio().compareTo(bloqueEmp2.getHoraFin()) == 0) 
							&&
							(bloqueEmp2.getHoraInicio().compareTo(bloqueEmp1.getHoraFin()) == -1 ||
							bloqueEmp2.getHoraInicio().compareTo(bloqueEmp1.getHoraFin()) == 0) ) {
						
						
						if(contadorCruces == 0) resultado = empleado1.getNombre() + "-" + empleado2.getNombre(); 
						
						contadorCruces++;

					}
				
				}
			
		}

		
	}
		
		
	resultado+= ": " + contadorCruces;	
	return resultado;
	
	}
	

}

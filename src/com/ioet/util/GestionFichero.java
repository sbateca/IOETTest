package com.ioet.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.ioet.model.Bloque;





/**
 * Clase que implementa métodos relacionados con el procesamiento de ficheros
 * @author Sergio Bateca
 *
 */
public class GestionFichero {
	
	
	GestionFechas gestionFechas = new GestionFechas();
	
	
	/**
	 * Método que extrae el contenido de un fichero ubicado en una ruta proporcionada
	 * @param rutaFichero corresponde a la ruta donde se encuentra el fichero
	 * @return List<String> una lista donde cada uno de los elementos corresponde a una línea del fichero
	 */
	public List<String> extraerTextoFichero(String rutaFichero) {
		
		File fichero = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		List<String> lineasString = new ArrayList<>();
		
		
		
		try {
				
			fichero = new File(rutaFichero);
			fr = new FileReader(fichero);
			br = new BufferedReader(fr);
			
			String lin;
			while((lin=br.readLine()) != null) {
				lineasString.add(lin);
			}
						
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
			
		}
		
		return lineasString;
	}
	
	
	
	/**
	 * Método que genera un fichero en la ruta proporcionada
	 * @param ruta corresponde a la ruta donde quedará almacenado el fichero a generar
	 * @param salida corresponde al contenido del fichero a generar
	 */
	public void generaFicheroSalida(String ruta, List<String> salida) {
		
		
		File archivoSalida = new File(ruta);
		FileWriter fichero = null;
		PrintWriter imprimeFichero = null;
		
		
		try {
			
			archivoSalida.createNewFile();
			fichero = new FileWriter(archivoSalida);
			imprimeFichero = new PrintWriter(fichero);
			
			Iterator<String> iterador = salida.iterator();
			
			
			while(iterador.hasNext()) {
				imprimeFichero.println(iterador.next());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fichero != null) fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		
		
	}
	
	
	
	/**
	 * Método que extrae el texto correspondiente a los bloques de una línea (empleado)
	 * @param linea de texto (empleado) al cual se van a extraer los bloques
	 * @return cadena de texto correspondiente a los bloques de un empleado
	 */
	public String extraerTextoBloques(String linea) {
		
		int posinIcial = linea.indexOf("=")+1;
		String textoBloques = linea.substring(posinIcial, linea.length());
		
		return textoBloques;
	}
	
	
	
	
	
	/**
	 * Método que extrae el nombre de un empleado de una línea de texto
	 * @param linea de texto a la cual se va a extraer el nombre de un empleado
	 * @return nombre del empleado
	 */
	public String extraerNombreLineaTexto(String linea) {
		
		String nombre = linea.substring(0, linea.indexOf("="));
		return nombre;
		
	}
	
	
	
	
	
	/**
	 * Método que genera un listado de bloques de acuerdo a la línea de texto recibida como parámetro
	 * @param linea de texto a la cual se desean generar bloques
	 * @return lista de bloques
	 */
	public List<Bloque> generaBloquesLineaTexto(String linea) {
		
		List<Bloque> listaBloques = new ArrayList<>();
				
		linea = linea.substring(linea.indexOf("=")+1, linea.length());
		String[] listaTexto = linea.split(",");
		List<String> listaTextoBloques = Arrays.asList(listaTexto);
		
		
		LocalTime horaInicio;
		LocalTime horaFin;
		TemporalAccessor temporalDiaSemana;
		
		for(String texto: listaTextoBloques) {
			
			String diaSemana = texto.substring(0, 2);
			String textoIntervaloHoras = texto.substring(2, texto.length());
			String[] listaTextoIntervalos = textoIntervaloHoras.split("-");
			
			
			horaInicio = gestionFechas.obtenerHoraString(listaTextoIntervalos[0]);
			horaFin = gestionFechas.obtenerHoraString(listaTextoIntervalos[1]);
			temporalDiaSemana = gestionFechas.extraerTemporalDiaSemana(diaSemana);
			
			listaBloques.add(new Bloque(temporalDiaSemana,horaInicio,horaFin));
		}
		
		
		return listaBloques;
		

	}
	
	
	
	
	
}

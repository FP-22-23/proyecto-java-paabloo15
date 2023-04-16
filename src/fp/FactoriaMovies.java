package fp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;

import java.util.stream.Stream;
import utiles.Checkers;


public class FactoriaMovies {


	//MÉTODO PARSING
	private static Movies parsearMovie(String linea) {
		Movies res;
		Checkers.checkNoNull(linea);
		String[] trozo = linea.split(";");
		LocalDate fechaEstreno = LocalDate.parse(trozo[10].trim(), 
				DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String tematica = trozo[0].trim();
		String titulo = trozo[8].trim();
		String estudio = trozo[7].trim();
		Integer duracion = Integer.parseInt(trozo[4].trim());
		Double recaudacion = Double.parseDouble(trozo[9].trim());
		Double puntuacion = Double.parseDouble(trozo[3].trim());
        Boolean mundial = null;
        	if(Double.parseDouble(trozo[9].trim())>700) {
        		mundial = true;
        	} else {
        		mundial = false;
        	};
        TipoPelicula tipo = null;
        	if((fechaEstreno.getYear()>=2015)) {
        		tipo = TipoPelicula.NUEVA;
        	} else {
        		tipo = TipoPelicula.ANTIGUA;
        	}
        List <String> otrasTematicas = List.of(trozo[1].trim(),trozo[2].trim());
        	
        	
		
        res = new Movies(fechaEstreno, tematica, puntuacion, duracion, titulo, recaudacion, 
				estudio, mundial, tipo, otrasTematicas);
		return res;
	}
	//LECTURA FICHERO
	public static Peliculas leePeliculas(String rutaFichero) {
		Peliculas res = null;
		try {
			Stream<Movies> peliculas = Files.lines(Paths.get(rutaFichero)).skip(1).map(FactoriaMovies::parsearMovie);
			res = new ContenedorMovies(peliculas);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return res;
	}


}

package fp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface Peliculas {

	/**
	 * @return El número de peliculas almacenado en el objeto peliculas.
	 */
	Integer getNumeroPeliculas();

	/**
	 * @param p pelicula
	 * Añade una pelicula al objeto.
	 */
	void añadirPeli(Movies p);
	
	/**
	 * @param p pelicula
	 * Elimina una pelicula del objeto.
	 */
	void eliminarPeli(Movies p);
	
	
	Boolean tieneAlgunasTematicas(String tematica1, String tematica2);


	Double getMediaRecaudacionPorTematica(String tematica);

	ArrayList<String> getPeliculasPorPuntuacion(Double n);
	
	public Map<String,List<String>> getPeliculasPorEstudio();
	
	public Map<String,Integer> getNumeroPeliculasPorTematica();





















































}

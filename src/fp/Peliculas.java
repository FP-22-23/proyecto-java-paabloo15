package fp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SortedMap;
import java.util.function.Function;
import java.util.stream.Stream;

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

	Boolean tieneAlgunasTematicas2(String tematica1, String tematica2);
	
	Double getMediaRecaudacionPorTematica2(String tematica);
	
	List<String> getPeliculasPorPuntuacion2(Double n);
	
	Optional <String> getPeliculaConMasPuntuacionPorTematica(String tematica);
	
	List<String> getPeliculasOrdenadasPorRecaudacionDeUnaTematica(String tematica);
	
	Map<String,List<String>> getPeliculasPorEstudio2(String estudio);
	
	int obtenerNumeroTotalGeneros();
	
	Map<Integer, Movies> obtenerPeliculasMaxMinPorAñoProduccion();

	SortedMap<String, List<Movies>> obtenerNMejoresPorEstudio(int n);
	
	String obtenerPeliculaMayorRecaudacion();

















































}

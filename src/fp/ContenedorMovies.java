package fp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContenedorMovies implements Peliculas{
	//ATRIBUTO
		private List<Movies> peliculas;
		
		
		//CONSTRUCTOR
		
		/**
		 * Crea un objeto de tipo Movies sin peliculas.
		 */
		public ContenedorMovies() {
			this.peliculas = new ArrayList<>();
		}
		/**
		 * @param peliculas Colección de peliculas. Crea un objeto de tipo Movies a
		 *                 partir de una colección de peliculas.
		 */
		public ContenedorMovies(Collection<Movies> pelicula) {
			this.peliculas = new ArrayList<Movies>(pelicula);
		}
		/**
		 * @param peliculas Stream de peliculas Crea un objeto de tipo Movies a partir
		 *                 de una colección de peliculas.
		 */
		public ContenedorMovies(Stream<Movies> pelicula) {
			this.peliculas = pelicula.collect(Collectors.toList());
		}

			
		//MÉTODOS BÁSICOS
	    public void añadirPeli(Movies p) {          //AÑADIR PELÍCULA 
	    	peliculas.add(p);
	    }
	    
	    public void eliminarPeli(Movies p) {        //ELIMINAR PELÍCULA, SI NO EXISTE LANZA EXCEPCIÓN
	        if (!peliculas.contains(p)) {
	            throw new IllegalArgumentException("La pelicula no existe");
	        } else {
	        	peliculas.remove(p);
	        }
	    }

	    public Integer getNumeroPeliculas() {    //OBTENER TAMAÑO
			return peliculas.size();
		}

		//METODOS CON BUCLES
		
		public Boolean tieneAlgunasTematicas(String tematica1, String tematica2) {
		Boolean res = false;
		for (Movies pelicula: peliculas) {
			if(pelicula.getTematica().equals(tematica1)) {
				if ((pelicula.getOtrasTematicas().contains(tematica2))){
				res=true;
				break;
				}
			   }	
		      }
		return res;
	    }
		
		
		public Double getMediaRecaudacionPorTematica(String tematica) {
		Integer cont=0; Double res=null;
		Double suma = 0.0 ;
		
		for (Movies pelicula: peliculas) {
			if(pelicula.getTematica().equals(tematica)) {
				suma+=pelicula.getRecaudacion();
				cont++;
			}
		}	
		if (cont>0){ res = (double)suma/cont;}
			return res;
		}

		
		public ArrayList<String> getPeliculasPorPuntuacion(Double n) {
			ArrayList<String> res = new ArrayList<String>();
			for (Movies pelicula: peliculas) {
				if (pelicula.getPuntuacion()>=n){
				res.add(pelicula.getTitulo());
				res.add(String.valueOf(pelicula.getAñoProduccion()));
				}
			}
			return res;
		}
		
		
		public Map<String,List<String>> getPeliculasPorEstudio(){
			Map<String,List<String>> res = new HashMap<String,List<String>>();
			for (Movies pelicula: peliculas) {
				String valor = pelicula.getTitulo();
					if (res.containsKey(pelicula.getEstudio())){
						res.get(pelicula.getEstudio()).add(valor);
					}
					else{
					List<String> lista = new ArrayList<String>();
					lista.add(valor);
					res.put(pelicula.getEstudio(), lista);
					}
				}
				
			return res;
		}


		public Map<String,Integer> getNumeroPeliculasPorTematica(){
			Map<String,Integer> res = new HashMap<String,Integer>();
			Map<String,List<String>> res2 = new HashMap<String,List<String>>();
			for (Movies pelicula: peliculas) {
					if (!res2.containsKey(pelicula.getTematica())){
						List<String> lista = new ArrayList<String>();
						lista.add(pelicula.getTitulo());
						res2.put(pelicula.getTematica(), lista);
					}
					else{
						res2.get(pelicula.getTematica()).add(pelicula.getTitulo());
					}
				}
			for (Map.Entry<String, List<String>> entry : res2.entrySet()) {
			    String tematica = entry.getKey();
			    List<String> peliculas = entry.getValue();
			    int cantidadPeliculas = peliculas.size();
			    res.put(tematica, cantidadPeliculas);
			}
			return res;
		}

		
		public Boolean tieneAlgunasTematicas2(String tematica1, String tematica2) {
			return peliculas.stream()
	                .anyMatch(movie ->
                    (movie.getTematica().equals(tematica1) && movie.getOtrasTematicas().contains(tematica2))
            );
}
		
		public Double getMediaRecaudacionPorTematica2(String tematica) {
			return peliculas.stream()
					.filter(p-> p.getTematica().equals(tematica))
						.mapToDouble(p-> p.getRecaudacion())
							.average()
								.getAsDouble();
						
			}
			
		
		public List<String> getPeliculasPorPuntuacion2(Double n) {
			
			return peliculas.stream()
				.filter(p-> p.getPuntuacion()>= n)
					.flatMap(pelicula -> List.of(pelicula.getTitulo(), String.valueOf(pelicula.getAñoProduccion())).stream())
						.collect(Collectors.toList());
		
		
		}
		
		
		public Optional<String> getPeliculaConMasPuntuacionPorTematica(String tematica) {
			return peliculas.stream()
					.filter(p-> p.getTematica().equals(tematica))
						.max(Comparator.comparingDouble(Movies::getPuntuacion))
							.map(pelicula -> pelicula.getTitulo() + " (" + pelicula.getAñoProduccion() + ")");
		}
		
		public List<String> getPeliculasOrdenadasPorRecaudacionDeUnaTematica(String tematica) {
			return peliculas.stream()
					.filter(p-> p.getTematica().equals(tematica))
						.sorted(Comparator.comparing(Movies::getRecaudacion))
							.map(p-> p.getTitulo() + " (" + p.getAñoProduccion() + ")")
								.collect(Collectors.toList());
		}
		
		public Map<String,List<String>> getPeliculasPorEstudio2(String estudio){
			return peliculas.stream()
		            .collect(Collectors.groupingBy(Movies::getEstudio, Collectors.mapping(Movies::getTitulo, Collectors.toList())));
		}
		
		

		public int obtenerNumeroTotalGeneros() {
		    int generosUnicos = peliculas.stream()
		            .map(Movies::getTematica)
		            .collect(Collectors.collectingAndThen(
		                    Collectors.toSet(),
		                    Set::size
		            ));

		    return generosUnicos;
		}
		
		
		public Map<Integer, Movies> obtenerPeliculasMaxMinPorAñoProduccion() {
		    Map<Integer, Movies> peliculasMaxMinPorAnio = peliculas.stream()
		            .collect(Collectors.groupingBy(
		                    Movies::getAñoProduccion,
		                    Collectors.collectingAndThen(
		                            Collectors.maxBy(Comparator.comparingInt(Movies::getAñoProduccion)),
		                            Optional::get
		                    )
		            ));

		    return peliculasMaxMinPorAnio;
		}
		
		
		public SortedMap<String, List<Movies>> obtenerNMejoresPorEstudio(int n) {
		    SortedMap<String, List<Movies>> resultado = peliculas.stream()
		            .collect(Collectors.groupingBy(Movies::getEstudio, TreeMap::new, Collectors.toList()));

		    return resultado.entrySet().stream()
		            .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream()
		                    .sorted(Comparator.comparing(Movies::getPuntuacion).reversed())
		                    .limit(n)
		                    .collect(Collectors.toList()), (l1, l2) -> l1, TreeMap::new));
		}
		
		
		
		public String obtenerPeliculaMayorRecaudacion() {
		    Map<String, Double> peliculasRecaudacion = new HashMap<>();
		    for (Movies pelicula : peliculas) {
		        peliculasRecaudacion.put(pelicula.getTitulo(), pelicula.getRecaudacion());
		    }

		    Map.Entry<String, Double> entryMayorRecaudacion = Collections.max(peliculasRecaudacion.entrySet(), Map.Entry.comparingByValue());

		    return entryMayorRecaudacion.getKey();
		}
		

		@Override
		public String toString() {
		    return "ContenedorMovies [ContenedorMovies =" + peliculas + "]";
		}
		
		
		//EQUALS Y HASHCODE
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((peliculas == null) ? 0 : peliculas.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ContenedorMovies other = (ContenedorMovies) obj;
			if (peliculas == null) {
				if (other.peliculas != null)
					return false;
			} else if (!peliculas.equals(other.peliculas))
				return false;
			return true;
		}
		
















































}




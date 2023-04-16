package fp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//TOSTRING
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




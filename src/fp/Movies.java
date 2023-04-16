package fp;

import java.time.LocalDate;
import java.util.List;

import utiles.Checkers;


public class Movies implements Comparable <String> {

	private LocalDate fechaEstreno;
	private Double puntuacion,recaudacion;
	private Integer duracion;
	private String titulo,estudio,tematica;
	private Boolean mundial;
	private TipoPelicula tipo;
	private List <String> otrasTematicas;
	
	public Movies(LocalDate fechaEstreno,String tematica, Double puntuacion, Integer duracion, String titulo, Double recaudacion, 
			String estudio, Boolean mundial, TipoPelicula tipo,List<String> otrasTematicas) {
		
		Checkers.check("La duración debe valer mayor o igual que uno", 
				duracion>=1);
		Checkers.check("La recaudación debe tener valores positivos", 
				recaudacion>=0);
		Checkers.check("La puntuación no puede ser negativa", 
				puntuacion>=0);
		
		this.fechaEstreno = fechaEstreno;
		this.tematica = tematica;
		this.puntuacion = puntuacion;
		this.duracion = duracion;
		this.titulo = titulo;
		this.recaudacion = recaudacion;
		this.estudio = estudio;
		this.mundial = mundial;
		this.tipo = tipo;
		this.otrasTematicas = otrasTematicas;
		
	}
	
	public Movies(LocalDate fechaEstreno,Integer duracion,String titulo, Double puntuacion, Double recaudacion) {
		
		this.fechaEstreno = fechaEstreno;
		this.tematica = null;
		this.puntuacion = puntuacion;
		this.duracion = duracion;
		this.titulo = titulo;
		this.recaudacion = recaudacion;
		this.estudio = null;
		this.mundial = null;
		this.tipo = null;
		this.otrasTematicas = null;
	}
	
	//MÉTODO TOSTRING
			public String toString() {
				return "Movies = [fechaEstreno = " + fechaEstreno + "tematica = " + tematica + ", puntuacion = " + puntuacion + ", duracion = " 
			            + duracion + ", titulo = " + titulo + ", recaudacion = " + recaudacion + ", estudio = " 
						+ estudio + ", puntuacion = " + puntuacion + ", mundial = " + mundial +  ", TipoPelicula = " + tipo + ", otrasTematicas = " + otrasTematicas + "]";
			}
			
	
	
	
	//MÉTODOS GETTERS Y SETTERS
		public LocalDate getFechaEstreno() {
			return fechaEstreno;
		}
		public void setFechaEstreno(LocalDate fechaEstreno) {
			this.fechaEstreno = fechaEstreno;
		}
		
		public String getTematica() {
			return tematica;
		}
		
		public void setTematica(String tematica) {
			this.tematica = tematica;
		}
		
		public Double getPuntuacion() {
			return puntuacion;
		}
		public void setPuntuacion(Double Puntuacion) {
			Checkers.check("La puntuación no puede ser negativa", 
					puntuacion>=0);
			this.puntuacion = puntuacion;
		}
		public Integer getDuracion() {
			return duracion;
		}
		public void setDuracion(Integer duracion) {
			Checkers.check("La duración debe tener valores positivos", 
					duracion>=0);
			this.duracion = duracion;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public Double getRecaudacion() {
			return recaudacion;
		}
		public void setRecaudacion(Double recaudacion) {
			Checkers.check("La recaudación debe tener valores positivos", 
					recaudacion>=0);
			this.recaudacion = recaudacion;
		}
		public String getEstudio() {
			return estudio;
		}
		public void setEstudio(String estudio) {
			this.estudio = estudio;
		}
		public Boolean getMundial() {
			return mundial;
		}
		public void setMundial(Boolean mundial) {
			this.mundial = mundial;
		}
		public TipoPelicula getTipo() {
			return tipo;
		}
		public void setTipo(TipoPelicula tipo) {
			this.tipo = tipo;
		}
		public List<String> getOtrasTematicas() {
			return otrasTematicas;
		}
		
		public void setOtrasTematicas(List<String> otrasTematicas) {
			this.otrasTematicas = otrasTematicas;
		}
		
		
		
		//PROPIEDADES DERIVADAS
		public Integer getAñoProduccion() {
			return this.fechaEstreno.getYear();
		}
		
	    public String getPopularidad() {
	    	if (this.getPuntuacion() >= 8.0) {
	    		String exitoso = "Éxito";
	    		return exitoso;
	    	}
	    	else {
	    		String exitoso = "No éxito";
	    		return exitoso;
	    	} 
	    }

		@Override
		public int compareTo(String o) {
			return 0;
		}
		/**
		 * Las peliculas se ordenan por fecha
		 */
		public int compareTo(Movies m) {
			int r;
			r = getFechaEstreno().compareTo(m.getFechaEstreno());
				
			
			return r;
		
		}
		public boolean equals(Object o) {
			
			boolean res = false;
			
			if (o instanceof Movies) {
				Movies m = (Movies) o;
				
				res = getTematica().equals(m.getTematica()) 
						&& getTitulo().equals(m.getTitulo());
			}
		return res;
		}
	
		public int hashCode() {
			return getTematica().hashCode() * 31;
		}
















}
		
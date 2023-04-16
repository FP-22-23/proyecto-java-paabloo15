package fp.test;

import java.time.LocalDate;
import java.util.List;

import fp.Movies;
import fp.TipoPelicula;

public class TestMovies {

	public static void main(String[] args) {
		//PRUEBA DEL MÉTODO TOSTRING
				Movies m1 = new Movies(LocalDate.of(2014, 10, 30),"Acción", 8.7, 123, "The Avengers", 
						345.0, "Marvel Studios", true,TipoPelicula.NUEVA,List.of("Tom Holland","Mark Ruffalo"));
				Movies m2 = new Movies(LocalDate.of(2019, 2, 15),null, 8.0, 102, "Us", 765.0, null,null, null, null);
				System.out.println(m1.toString());
				System.out.println(m2.toString());
		    
			
			
			//TEST GETTERS
			System.out.println(m2.getFechaEstreno());
			System.out.println(m1.getTematica());
			System.out.println(m1.getMundial());
			System.out.println(m1.getRecaudacion());
			System.out.println(m2.getTitulo());
			System.out.println(m2.getEstudio());
			System.out.println(m1.getDuracion());
			System.out.println(m1.getPuntuacion());
			System.out.println(m1.getTipo());
			System.out.println(m1.getAñoProduccion());
		    System.out.println(m1.getPopularidad());
		    System.out.println(m1.getOtrasTematicas());

			
			
			//TEST SETTERS
			m1.setFechaEstreno(LocalDate.of(2019, 2, 15));
			m2.setTematica("Acción");
			m1.setTitulo("The One with the Cat");
			m2.setEstudio("UCM");
			m1.setDuracion(105);
			m2.setPuntuacion(7.0);
			m1.setRecaudacion(633.3431);
			m1.setMundial(false);
			m2.setTipo(TipoPelicula.ANTIGUA);
			m2.setOtrasTematicas(List.of("Antonio Banderas"));
			
			
				
				
			//TEST IGUALDAD
			if(m1.equals(m2)) { 
				System.out.println("Misma película");
			} else {
				System.out.println("Distinta película");
			}
			
			
			
			//TEST DEL COMPARETO
			int resp = m1.compareTo(m2);
		    if(resp == 0) {
				System.out.println("Se estrenaron el mismo dia");
			} 
			else if(resp > 0) {
				System.out.println("La pelicula " + m1.getTitulo() + " se estrenó después que la película " + m2.getTitulo());
			}
			else
				System.out.println("La pelicula " + m1.getTitulo() + " se estrenó antes que la película " + m2.getTitulo());
			}
		    //NOTA: el compareTo antes mide la fecha y si esta es igual en los 2 objetos, miraría el título luego.
			
			
		

	}



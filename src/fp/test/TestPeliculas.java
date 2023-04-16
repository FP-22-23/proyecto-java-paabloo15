package fp.test;


import fp.FactoriaMovies;
import fp.Peliculas;

public class TestPeliculas {

	public static void main(String[] args) {
		Peliculas peliculas = FactoriaMovies.leePeliculas("data/blockbusters.csv");
		
		System.out.println("\ntestTieneAlgunasTematicas");
		System.out.println("===============================");		
		testTieneAlgunasTematicas(peliculas, "Action", "Drama");
		testTieneAlgunasTematicas(peliculas, "Thriller", "Action");
		
		System.out.println("\ntestGetMediaRecaudacionPorTematica");
		System.out.println("===============================");		
		testGetMediaRecaudacionPorTematica(peliculas, "Action");
		testGetMediaRecaudacionPorTematica(peliculas, "Crime");
	    
		System.out.println("\ntestGetPeliculasPorPuntuacion");
		System.out.println("===============================");		
		testGetPeliculasPorPuntuacion(peliculas, 6.0);
		testGetPeliculasPorPuntuacion(peliculas, 8.0);
		
		System.out.println("\ntestGetPeliculasporEstudio");
		System.out.println("===============================");		
		testGetPeliculasporEstudio(peliculas);
	
		System.out.println("\ntestGetNumeroPeliculasPorTematica");
		System.out.println("===============================");		
		testGetNumeroPeliculasPorTematica(peliculas);

	
	
	
	}
		
		private static void testTieneAlgunasTematicas(Peliculas peliculas, String tematica1, String tematica2) {
			try {
				String msg = String.format(
						"\n¿Hay alguna pelicula con %s y %s ? %b", 
						tematica1,tematica2, peliculas.tieneAlgunasTematicas(tematica1,tematica2));
				System.out.println(msg);
			} catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}

		
		}

		private static void testGetMediaRecaudacionPorTematica(Peliculas peliculas, String tematica) {

			try {
				String msg = String.format(
						"\nEl promedio de la recaudaciones medias (en millones) para las peliculas con tematica %s es %f", tematica,
						peliculas.getMediaRecaudacionPorTematica(tematica));
				System.out.println(msg);
			} catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}

		}

		private static void testGetPeliculasPorPuntuacion(Peliculas peliculas,Double n) {
			
			try {
				String msg = String.format(
						"\nLas peliculas con mas de %f de puntuacion según imdb son:  \n%s", 
						n, peliculas.getPeliculasPorPuntuacion(n));
				System.out.println(msg);
			} catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}	
		}
		
		private static void testGetPeliculasporEstudio(Peliculas peliculas) {
			try {
				System.out.println("Las peliculas de los respectivos estudios son: " + peliculas.getPeliculasPorEstudio());
			} catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}	
		}
		
		private static void testGetNumeroPeliculasPorTematica(Peliculas peliculas) {
			try {
				System.out.println("\nEl numero de peliculas por Tematicas es: " + peliculas.getNumeroPeliculasPorTematica());
			} catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}	
		}
		
}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

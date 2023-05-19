package fp.test;


import java.util.function.Function;

import fp.FactoriaMovies;
import fp.Movies;
import fp.Peliculas;

public class TestPeliculas {

	public static void main(String[] args) {
		Peliculas peliculas = FactoriaMovies.leePeliculas("data/blockbusters.csv");
		
		System.out.println("\ntestTieneAlgunasTematicas");
		System.out.println("===============================");		
		testTieneAlgunasTematicas(peliculas, "Action", "Drama");
		testTieneAlgunasTematicas(peliculas, "Crime", "Music");
		
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
		
		System.out.println("\ntestTieneAlgunasTematicas2");
		System.out.println("===============================");		
		testTieneAlgunasTematicas2(peliculas, "Action", "Drama");
		testTieneAlgunasTematicas2(peliculas, "Crime", "Music");

		System.out.println("\ntestGetMediaRecaudacionPorTematica2");
		System.out.println("===============================");		
		testGetMediaRecaudacionPorTematica2(peliculas, "Action");
		testGetMediaRecaudacionPorTematica2(peliculas, "Crime");
		
		System.out.println("\ntestGetPeliculasPorPuntuacion2");
		System.out.println("===============================");		
		testGetPeliculasPorPuntuacion2(peliculas, 6.0);
		testGetPeliculasPorPuntuacion2(peliculas, 8.0);
	
		System.out.println("\ntestGetPeliculaConMasPuntuacionPorTematica");
		System.out.println("===============================");		
		testGetPeliculaConMasPuntuacionPorTematica(peliculas, "Action");
		testGetPeliculaConMasPuntuacionPorTematica(peliculas, "Crime");
	
		System.out.println("\ntestGetPeliculasOrdenadasPorRecaudacionDeUnaTematica");
		System.out.println("===============================");		
		testGetPeliculasOrdenadasPorRecaudacionDeUnaTematica(peliculas, "Action");
		testGetPeliculasOrdenadasPorRecaudacionDeUnaTematica(peliculas, "Crime");
		
		System.out.println("\ntestGetPeliculasporEstudio2");
		System.out.println("===============================");		
		testGetPeliculasporEstudio2(peliculas);
		
		System.out.println("\ntestObtenerNumeroTotalGeneros");
		System.out.println("===============================");		
		testObtenerNumeroTotalGeneros(peliculas);
		
		System.out.println("\ntestObtenerPeliculasMaxMinPorAñoProduccion()");
		System.out.println("===============================");		
		testObtenerPeliculasMaxMinPorAñoProduccion(peliculas);
		
		
		System.out.println("\ntestObtenerNMejoresPorEstudio");
		System.out.println("===============================");		
		testObtenerNMejoresPorEstudio(peliculas,3);
		
		System.out.println("\ntestobtenerPeliculaMayorRecaudacion");
		System.out.println("===============================");		
		testobtenerPeliculaMayorRecaudacion(peliculas);

	
	
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
		
		private static void testTieneAlgunasTematicas2(Peliculas peliculas, String tematica1, String tematica2) {
			try {
				String msg = String.format(
						"\n¿Hay alguna pelicula con %s y %s ? %b", 
						tematica1,tematica2, peliculas.tieneAlgunasTematicas(tematica1,tematica2));
				System.out.println(msg);
			} catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
		}
		
		private static void testGetMediaRecaudacionPorTematica2(Peliculas peliculas, String tematica) {

			try {
				String msg = String.format(
						"\nEl promedio de la recaudaciones medias (en millones) para las peliculas con tematica %s es %f", tematica,
						peliculas.getMediaRecaudacionPorTematica2(tematica));
				System.out.println(msg);
			} catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}

		}

		private static void testGetPeliculasPorPuntuacion2(Peliculas peliculas,Double n) {
					
					try {
						String msg = String.format(
								"\nLas peliculas con mas de %f de puntuacion según imdb son:  \n%s", 
								n, peliculas.getPeliculasPorPuntuacion2(n));
						System.out.println(msg);
					} catch (Exception e) {
						System.err.println("Capturada excepción inesperada: " + e.getMessage());
					}	
				}

		private static void testGetPeliculaConMasPuntuacionPorTematica(Peliculas peliculas, String tematica) {
			
			try {
				String msg = String.format(
						"\nLas peliculas con mas puntuacion de %s según imdb es:  \n%s", 
						tematica, peliculas.getPeliculaConMasPuntuacionPorTematica(tematica));
				System.out.println(msg);
			} catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}	
		}

		private static void testGetPeliculasOrdenadasPorRecaudacionDeUnaTematica(Peliculas peliculas, String tematica) {
					
					try {
						String msg = String.format(
								"\nLas peliculas con mas recaudacion de %s según imdb son:  \n%s", 
								tematica, peliculas.getPeliculasOrdenadasPorRecaudacionDeUnaTematica(tematica));
						System.out.println(msg);
					} catch (Exception e) {
						System.err.println("Capturada excepción inesperada: " + e.getMessage());
					}	
				}

		private static void testGetPeliculasporEstudio2(Peliculas peliculas) {
			try {
				System.out.println("\nLas peliculas de los respectivos estudios son: " + peliculas.getPeliculasPorEstudio());
			} catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}	
		}

		private static void testObtenerNumeroTotalGeneros(Peliculas peliculas) {
			try {
				System.out.println("\nEl número de tematicas distintas: " + peliculas.obtenerNumeroTotalGeneros());
			} catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}	
		}
		
		private static void testObtenerPeliculasMaxMinPorAñoProduccion(Peliculas peliculas) {
			try {
				System.out.println("\nPeliculas por año: " + peliculas.obtenerPeliculasMaxMinPorAñoProduccion());
			} catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}	
		}
		
		private static void testObtenerNMejoresPorEstudio(Peliculas peliculas, int n) {
			try {
				String msg = String.format(
						"\nLas %d mejores peliculas de cada estudio son: %s", 
						n, peliculas.obtenerNMejoresPorEstudio(n).toString());
				System.out.println(msg);

			} catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}	
		}

		private static void testobtenerPeliculaMayorRecaudacion(Peliculas peliculas) {
			try {
				System.out.println("\nLa pelicula con mas recaudacion es:  " + peliculas.obtenerPeliculaMayorRecaudacion());
			} catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}	
		}







































}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

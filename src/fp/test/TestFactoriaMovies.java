package fp.test;

import fp.FactoriaMovies;
import fp.Peliculas;


public class TestFactoriaMovies {
	public static void main(String[] args) {
		testLeerMovies();
	}

	private static void testLeerMovies() {
		System.out.println("Test Movies       :");
		Peliculas pelicula = FactoriaMovies.leePeliculas("data/blockbusters.csv");
		System.out.println("Pelicula: " + pelicula);
		System.out.println("\n"+ pelicula.getNumeroPeliculas());
	}

}
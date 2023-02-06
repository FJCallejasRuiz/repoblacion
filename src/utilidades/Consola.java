package utilidades;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private Consola() {

	}

	public static int leerAnchura() {
		int anchura = 0;
		System.out.println("Introduce la anchura del bosque:");
		anchura = Entrada.entero();
		while (anchura > 1000 || anchura < 10) {
			System.out.println("ERROR: Introduzca una anchura correcta (Mínimo de 10 y Máximo de 1000):");
			anchura = Entrada.entero();
		}
		return anchura;

	}

	public static int leerAltura() {
		int altura = 0;
		System.out.println("Introduce la altura del bosque:");
		altura = Entrada.entero();
		while (altura > 500 || altura < 10) {
			System.out.println("ERROR: Introduzca una altura correspondiente. (Mínimo 10 y máximo 500).");
			altura = Entrada.entero();
		}
		return altura;
	}
	public static int leePoblacion() {
		int poblacion = 0;
		System.out.println("Introduce la población del bosque:");
		poblacion = Entrada.entero();
		while (poblacion < 10){
			System.out.println("ERROR: Introduzca una población correspondiente. (Mínimo 1).");
			poblacion = Entrada.entero();
		}
		return poblacion;
	}
	}


package utilidades;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private Consola() {

	}

	public int leerAnchura() {
		int anchura = 0;
		do {
			System.out.println("Introduce la anchura del bosque:");
			anchura = Entrada.entero();
		} while (anchura > 1000 || anchura < 10);
		return anchura;

	}

	public int leerAltura() {
		int altura = 0;
		do {
			System.out.println("Introduce la anchura del bosque:");
			altura = Entrada.entero();
		} while (altura > 500 || altura < 10);
		return altura;
	}

	public int leePoblacion() {
		int poblacion = 0;
		do {
			System.out.println("Introduce la anchura del bosque:");
			poblacion = Entrada.entero();
		} while (poblacion < 0);
		return poblacion;
	}
}

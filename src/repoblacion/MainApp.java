package repoblacion;

import modelo.Bosque;
import utilidades.Consola;

public class MainApp {

	private static Bosque bosque;

	public static void main(String[] args) {
		try {
			bosque = new Bosque(Consola.leerAnchura(), Consola.leerAltura(), Consola.leePoblacion());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		if (bosque != null) {
			try {
				bosque.realizarCalculos();
			}catch ( NullPointerException e) {
				System.out.println(e.getMessage());
			}
		}
	
		System.out.println(bosque.toString());
		
		
	}
}

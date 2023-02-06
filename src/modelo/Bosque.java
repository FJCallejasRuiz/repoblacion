package modelo;

import java.util.Random;

public class Bosque {
	public final int MAX_ALTURA = 500;
	public final int MINIMO = 10;
	public final int MAX_ANCHURA = 1000;
	public final int MAX_ESPECIES = 4;
	private Arbol[] arboles;
	private Arbol arbolMasAlejado;
	private Arbol arbolMasCentrado;
	/*private Random generador;*/
	private int ancho;
	private int alto;

	public Bosque(int ancho, int alto, int poblacion) {
		
		this.setAncho(ancho);
		this.setAlto(alto);
		checkPoblacion (poblacion);
		this.arboles = new Arbol[poblacion];
		this.repoblar();
		
	}
	
	public void checkPoblacion ( int poblacion) {
		if ( poblacion > 2*(this.ancho+this.alto)){
			throw new IllegalArgumentException("ERROR: La población no puede superar el perímetro del bosque.");
		}if (poblacion < 1) {
			throw new IllegalArgumentException("ERROR: La población debe ser mayor que cero.");
		}
	}

	private void repoblar() {

		Especie[] max_especies = new Especie[MAX_ESPECIES];
		Especie[] especie_placebo = Especie.values();
		Especie especieAMostrar= null;
		int tamaño = especie_placebo.length;
		int tamañoMax = max_especies.length;
		int especieAleatoria = 0;

		boolean bandera = false;
		boolean banderaEspecie = false;
		boolean centinelaPrueba = false;
		int centinelaInt = 1;

		for (int i = 0; i < this.arboles.length; i++) {
			if (bandera == false) {
				Posicion posicionDefinitiva = new Posicion(posicionAleatoria());

				if (i == 0) {
					especieAleatoria = new Random().nextInt((tamaño) - 1);
					especieAMostrar = especie_placebo[especieAleatoria];
				}else {
					especieAleatoria = new Random().nextInt((tamaño) - 1);
					especieAMostrar = especie_placebo[especieAleatoria];
					while ((especieAMostrar.equals(Especie.ALAMO) && ((arboles[i - 1].getEspecie().equals(Especie.CASTANO))
							|| (arboles[i - 1].getEspecie().equals(Especie.CIPRES))
							|| (arboles[i - 1].getEspecie().equals(Especie.OLIVO))))
							|| (especieAMostrar.equals(Especie.OLIVO) && (arboles[i - 1].getEspecie().equals(Especie.ALAMO)
									|| arboles[i - 1].getEspecie().equals(Especie.ENCINA)))) {
						especieAleatoria = new Random().nextInt((tamaño) - 1);
						especieAMostrar = especie_placebo[especieAleatoria];
					}
				}
				
				arboles[i] = new Arbol(especieAMostrar, posicionDefinitiva);
				if (i == 0) {
					max_especies[0] = arboles[0].getEspecie();
				} else {
					banderaEspecie = false;
					for (int j = 0; j < i; j++) {
						if (arboles[j].getEspecie().equals(especieAMostrar)) {
							banderaEspecie = true;
						}

					}
					if (banderaEspecie == false) {
						centinelaPrueba = false;
						for (int k = 0; k < max_especies.length && !centinelaPrueba; k++) {
							if (max_especies[k] == null) {
								max_especies[k] = arboles[i].getEspecie();
								centinelaPrueba = true;
								centinelaInt = centinelaInt + 1;
							}
						}
					}
					if (centinelaInt == MAX_ESPECIES) {
						bandera = true;
					}

				}

			} else {
				Posicion posicionDefinitiva = new Posicion(posicionAleatoria());

				especieAleatoria = new Random().nextInt((tamañoMax) - 1);
				especieAMostrar = max_especies[especieAleatoria];

				while ((especieAMostrar.equals(Especie.ALAMO) && ((arboles[i - 1].getEspecie().equals(Especie.CASTANO))
						|| (arboles[i - 1].getEspecie().equals(Especie.CIPRES))
						|| (arboles[i - 1].getEspecie().equals(Especie.OLIVO))))
						|| (especieAMostrar.equals(Especie.OLIVO) && (arboles[i - 1].getEspecie().equals(Especie.ALAMO)
								|| arboles[i - 1].getEspecie().equals(Especie.ENCINA)))) {
					especieAleatoria = new Random().nextInt((tamañoMax) - 1);
					especieAMostrar = max_especies[especieAleatoria];
				}
				arboles[i] = new Arbol(especieAMostrar, posicionDefinitiva);

			}
		 
		}
		
	}

	private Posicion posicionAleatoria() {
		Posicion posicionAleatoria = new Posicion(Math.random() * (this.ancho) - (this.ancho / 2),
				Math.random() * (this.alto) - (this.alto / 2));
		return posicionAleatoria;
	}

	
	public void realizarCalculos() {
		Posicion centro = new Posicion(0, 0);
		boolean primero = false;
		
		for (int i = 0; i < this.arboles.length; i++) {
			if (arboles[i] == null) {
				throw new NullPointerException("ERROR: arbol nulo");
			}
			if (primero == false) {
				arboles[i].getPosicion().distancia(centro);
				arbolMasAlejado = new Arbol(arboles[i]);
				arbolMasCentrado = new Arbol(arboles[i]);
				primero = true;

			}else {
				if (arboles[i].getPosicion().distancia(centro) > arbolMasAlejado.getPosicion().distancia(centro)) {
					arbolMasAlejado = new Arbol(arboles[i]);

				}
				if (arboles[i].getPosicion().distancia(centro) < arbolMasCentrado.getPosicion().distancia(centro)) {
					arbolMasCentrado = new Arbol(arboles[i]);

				}
			}
			
			

		}
	}

	public Arbol[] duplicaBosque() {
		Arbol[] coleccionTemp = new Arbol[arboles.length];
		for (int i = 0; i < arboles.length; i++) {
			if (arboles[i] != null) {
				coleccionTemp[i] = new Arbol(arboles[i]);
			}
		}
		return coleccionTemp;

	}

	public Arbol getArbolMasAlejado() {
		return arbolMasAlejado;
	}

	public Arbol getArbolMasCentrado() {
		return arbolMasCentrado;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		if (ancho < MINIMO || ancho > MAX_ANCHURA) {
			throw new IllegalArgumentException("ERROR: Anchura no válida.");
		}
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		if (alto < MINIMO || alto > MAX_ALTURA) {
			throw new IllegalArgumentException("ERROR: Altura no válida.");
		}
		this.alto = alto;
	}

	@Override
	public String toString() {
		for (Arbol arbol: arboles) {
			System.out.println(arbol);
		}
		System.out.println("------------------------------------------------------------------------------------s");
		return "Bosque [arbolMasAlejado=" + arbolMasAlejado + ", arbolMasCentrado=" + arbolMasCentrado + "]";
		
	}

}

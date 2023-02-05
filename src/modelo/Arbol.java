package modelo;

public class Arbol {
	private Posicion posicion;
	private Especie especie;

	public Arbol(Especie especie, Posicion posicion) {
		this.setEspecie(especie);
		this.setPosicion(posicion);
	}

	public Arbol(Arbol a) {
		if (a == null) {
			throw new NullPointerException("ERROR: No se puede copiar un árbol nulo.");
		}
		especie = a.getEspecie();
		posicion = a.getPosicion();
	}

	public Posicion getPosicion() {
		return posicion;
	}

	private void setPosicion(Posicion posicion) {
		if (posicion == null) {
			throw new NullPointerException("ERROR: La posición no puede ser nula.");
		}
		this.posicion = posicion;
	}

	public Especie getEspecie() {
		return especie;
	}

	private void setEspecie(Especie especie) {
		if (especie == null) {
			throw new NullPointerException("ERROR: La especie no puede ser nula.");
		}
		this.especie = especie;
	}

	@Override
	public String toString() {
		return "especie=" + especie + ", posicion=(" + posicion + ")";
	}

}

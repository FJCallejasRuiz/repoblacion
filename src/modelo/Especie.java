package modelo;

public enum Especie {
	ALAMO("Álamo"), ENCINA("Encina"), CASTANO("Castaño"), CIPRES("Ciprés"), PINO("Pino"), ROBLE("Roble"),
	OLIVO("Olivo");

	public String cadenaAMostrar;

	private Especie(String cadenaAMostrar) {
		this.cadenaAMostrar = cadenaAMostrar;
	}
	
	@Override
	public String toString() {
		return cadenaAMostrar;

	}
}

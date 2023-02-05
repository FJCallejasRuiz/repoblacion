package modelo;

import java.text.DecimalFormat;

public class Posicion {
	private double x, y;

	public Posicion(double x, double y) {
		this.setX(x);
		this.setY(y);
	}

	public Posicion(Posicion p) {
		if (p == null) {
			throw new NullPointerException("ERROR: No se puede copiar una posición nula.");
		}
		x = p.getX();
		y = p.getY();
	}
	
	public double distancia(Posicion posicion) {
		if (posicion == null) {
			throw new NullPointerException("ERROR: No se puede calcular la distancia a una posición nula.");
		}if (this.getX()== posicion.getX() && this.getY()== posicion.getY()) {
			return 0;
		}
		double distanciaADar = Math.sqrt(Math.pow((posicion.getX()-this.getX()), 2)+Math.pow((posicion.getY()-this.getY()), 2));
		return distanciaADar;
		
	}

	public double getX() {
		return x;
	}

	private void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	private void setY(double y) {
	
		this.y = y;
	}

	@Override
	public String toString() {
		DecimalFormat tresDigitos= new DecimalFormat("#.000");
		return "x=" + tresDigitos.format(x) + ", y=" + tresDigitos.format(y);
	}

	
	
	
	
}

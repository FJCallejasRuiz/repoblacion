package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;



import org.junit.jupiter.api.Test;

import repoblacion.modelo.Posicion;

public class PosicionTest {
		
	private static final String ERROR_COPIAR_POSICION_NULA = "ERROR: No se puede copiar una posición nula.";
	private static final String ERROR_DISTANCIA_POSICION_NULA = "ERROR: No se puede calcular la distancia a una posición nula.";
	private static final String DISTANCIA_DEBERIA_SER_CERO = "ERROR: La distancia debería ser 0 ya que no se puede calcular la distancia de una posición nula.";
	private static final String POSICION_NULA = "Debería haber saltado una excepción indicando que no se puede copiar una posición nula.";
	private static final String MENSAJE_NO_CORRECTO = "El mensaje devuelto por la excepción no es correcto.";
	private static final String OBJETO_DEBERIA_SER_NULO = "No se debería haber creado el objeto posición.";
	private static final String TIPO_NO_CORRECTO = "El tipo de la excepción no es correcto.";
	private static final String DISTANCIA_CALCULADA_INCORRECTAMENTE="El cálculo de la distancia no está correctamente calculado.";
	private static final String CADENA_NO_ESPERADA = "La cadena devuelta no es la esperada.";
	private static final String POSICION_X_NO_ESPERADA="La posición de la coordenada X no es la esperada.";
	private static final String POSICION_Y_NO_ESPERADA="La posición de la coordenada Y no es la esperada.";

	@Test
	public void constructorPosicionNulaLanzaExcepcion() {
		Posicion posicion = null;
		
		try {
			posicion = new Posicion(null);
			fail(POSICION_NULA);
		} catch (NullPointerException e) {
			assertEquals(ERROR_COPIAR_POSICION_NULA, e.getMessage(), MENSAJE_NO_CORRECTO);
			assertEquals(null, posicion, OBJETO_DEBERIA_SER_NULO);
		} catch (Exception e) {
			fail(TIPO_NO_CORRECTO);
		}
	}
	
	@Test
	public void constructorPosicionCorrecta() {
		Posicion posicion = null;
		
		posicion = new Posicion(5.0,6.0);
		assertEquals(5.0, posicion.getX(), POSICION_X_NO_ESPERADA);
		assertEquals(6.0, posicion.getY(), POSICION_Y_NO_ESPERADA);
		
	}
	
	@Test
	public void distanciaPosicionNulaLanzaExcepcion() {
		Posicion posicion = null;
		double d=0.0;
		try {
			posicion = new Posicion(5,6);
			d=posicion.distancia(null);
			fail(POSICION_NULA);
		} catch (NullPointerException e) {
			assertEquals(ERROR_DISTANCIA_POSICION_NULA, e.getMessage(), MENSAJE_NO_CORRECTO);
			assertEquals(0.0, d, DISTANCIA_DEBERIA_SER_CERO);
		} catch (Exception e) {
			fail(TIPO_NO_CORRECTO);
		}
	}
	
	@Test
	public void distanciaPosicionCorrecta() {
		Posicion posicion = null;
		double d=0.0;
		
		
			posicion = new Posicion(5,5);
			d=posicion.distancia(new Posicion (9,8));
			assertEquals(5.0, d, DISTANCIA_CALCULADA_INCORRECTAMENTE);
	}
	
	@Test
	public void toStringDevuelveLaCadenaEsperada() {
		Posicion posicion = new Posicion(5.0,5.0);

		
		assertEquals(String.format("x=%5.3f, y=%5.3f", 5.0,5.0), posicion.toString(), CADENA_NO_ESPERADA);
	}

}

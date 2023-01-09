/**
 * Swing_c_p02_FdezVegaAlvarezHugo-swing_c_p02_FdezVegaAlvarezHugo-Main.java
 * 21 nov 2022 9:17:26
 * @author Hugo Fdez-Vega Alvarez
 */
package swing_c_p02_FdezVegaAlvarezHugo;

import java.awt.Color;

/**
 * The Class Main.
 *
 * @author Hugo Fdez-Vega Alvarez
 */
public class Main {

	/**
	 * Método main, que crea una Ventana y se la pasa a esta misma.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Ventana miVentana=new Ventana();
		miVentana.setVentana(miVentana);
		miVentana.setVisible(true);

	}

}

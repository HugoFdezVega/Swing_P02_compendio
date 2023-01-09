/**
 * Swing_c_p02_FdezVegaAlvarezHugo-swing_c_p02_FdezVegaAlvarezHugo-Panel1.java
 * 21 nov 2022 10:57:29
 * @author Hugo Fdez-Vega Alvarez
 */
package swing_c_p02_FdezVegaAlvarezHugo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Clase Panel1
 *
 * @author Hugo Fdez-Vega Alvarez
 */
public class Panel1 extends JPanel{
	Border borde = BorderFactory.createLineBorder(Color.BLUE, 2);
	
	/**
	 * Constructor del panel1 con sus distintos atributos.
	 */
	public Panel1() {
		Color color=new Color(255, 225, 93);
		this.setBorder(borde);
		this.setBackground(color);
		JLabel nombreHotel=new JLabel("Holtel Paraíso");
		nombreHotel.setFont(new java.awt.Font("Agency FB", 1, 100));
		this.add(nombreHotel);
	}

}

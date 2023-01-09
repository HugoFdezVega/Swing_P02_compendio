/**
 * Swing_c_p02_FdezVegaAlvarezHugo-swing_c_p02_FdezVegaAlvarezHugo-Panel4.java
 * 24 nov 2022 8:35:27
 * @author Hugo Fdez-Vega Alvarez
 */
package swing_c_p02_FdezVegaAlvarezHugo;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * Clase Panel4.
 *
 * @author Hugo Fdez-Vega Alvarez
 */
public class Panel4 extends JPanel{
	
	/**
	 * Constructor de Panel4.
	 *
	 * @param panelDatos, donde irá el resumen de los datos personales
	 * @param panelHabitacion, donde irá el resumen de los datos de la habitación
	 */
	public Panel4(Panel panelDatos, Panel panelHabitacion) {
		//Declaramos, instanciamos y aplicamos el borde del panel
		Color color=new Color(176, 30, 104);
		Color fondo=new Color(41, 52, 98);
		Border borde = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(color, 2), "Resumen", TitledBorder.CENTER, TitledBorder.TOP, null, color);
		this.setBorder(borde);
		this.setBackground(fondo);
		//Aplicamos el layout
		this.setLayout(new BorderLayout());
		//Creamos el JTabbedPane, le aplicamos sus pestañas y les pasamos los paneles que llegaron por parámetro
		JTabbedPane resumen=new JTabbedPane();
		resumen.addTab("Datos personales", panelDatos);
		resumen.addTab("Habitación", panelHabitacion);
		resumen.setForeground(color);
		this.add(resumen);
	}

}

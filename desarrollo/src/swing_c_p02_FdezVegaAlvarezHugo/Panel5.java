/**
 * Swing_c_p02_FdezVegaAlvarezHugo-swing_c_p02_FdezVegaAlvarezHugo-Panel5.java
 * 24 nov 2022 8:17:02
 * @author Hugo Fdez-Vega Alvarez
 */
package swing_c_p02_FdezVegaAlvarezHugo;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Clase Panel5.
 *
 * @author Hugo Fdez-Vega Alvarez
 */
public class Panel5 extends JPanel{
	
	// Instanciamos el layout y su constraints
	private GridBagConstraints constraints = new GridBagConstraints();
	private GridBagLayout layout = new GridBagLayout();
	
	/**
	 * Constructor del Panel5.
	 *
	 * @param btImprimir boton imprimir
	 * @param btNuevo boton nuevo
	 * @param btGuardar boton guardar
	 */
	public Panel5(JButton btImprimir, JButton btNuevo, JButton btGuardar) {
		Color fondo=new Color(54, 28, 64 );
		this.setBackground(fondo);
		// Aplicamos el layout y el formato de las constraints
		this.setLayout(layout);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.weightx = 0; // no puede crecer a lo ancho
		constraints.weighty = 0; // no puede crecer a lo alto
		//Declaramos e instnaciamos las imágenes de los botones
		ImageIcon imgImprimir=new ImageIcon(getClass().getResource("recursos/imprimir.png"));
		ImageIcon imgNuevo=new ImageIcon(getClass().getResource("recursos/nuevo.png"));
		ImageIcon imgGuardar=new ImageIcon(getClass().getResource("recursos/guardar.png"));
		//Aplicamos las imágenes a los botones
		btImprimir.setIcon(imgImprimir);
		btNuevo.setIcon(imgNuevo);
		btGuardar.setIcon(imgGuardar);
		//Posicionamos los botones
		this.addComponent(btImprimir, 0, 0, 1, 1);
		this.addComponent(btNuevo, 1, 0, 1, 1);
		this.addComponent(btGuardar, 2, 0, 1, 1);
	}
	
	/**
	 * addComponent() para situar componentes en el layout.
	 *
	 * @param component the component
	 * @param column the column
	 * @param row the row
	 * @param width the width
	 * @param height the height
	 */
	private void addComponent(Component component, int column, int row, int width, int height) {
		constraints.gridx = column; // La columna en la que se colocará componente.
		constraints.gridy = row; // La fila en la que se colocará componente.
		constraints.gridwidth = width; // Número de columnas que ocupa el componente.
		constraints.gridheight = height; // Número de filas que ocupa el componente.
		layout.setConstraints(component, constraints); // Asignamos las constrains al componente
		this.add(component); // Asignamos el componente al layout
	}
}

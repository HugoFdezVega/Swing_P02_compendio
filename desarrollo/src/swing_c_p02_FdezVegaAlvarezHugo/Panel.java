/**
 * Swing_c_p02_FdezVegaAlvarezHugo-swing_c_p02_FdezVegaAlvarezHugo-Panel.java
 * 21 nov 2022 10:11:27
 * @author Hugo Fdez-Vega Alvarez
 */
package swing_c_p02_FdezVegaAlvarezHugo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.Border;



/**
 * Clase Panel.
 *
 * @author Hugo Fdez-Vega Alvarez
 */
public class Panel extends JPanel{
	JTextArea taResumen;
	
	/**
	 * Constructor vacío con layout por defecto.
	 */
	
	public Panel() {

	}
	
	/**
	 * Constructor para los paneles que se le pasarán a Panel5
	 *
	 * @param taResumen JTextArea
	 */
	public Panel(JTextArea taResumen) {
		Color fondo=new Color(218, 216, 218);
		taResumen.setBackground(fondo);
		this.setLayout(new BorderLayout());
		Font fuenteResumen=new Font(taResumen.getFont().getName(),Font.BOLD,20);
		taResumen.setFont(fuenteResumen);
		this.taResumen=taResumen;
		this.add(taResumen);	
	}
	
	/**
	 * IConstrucor para el panel que se le pasrá al PanelExtra
	 *
	 * @param rb1 boton1
	 * @param rb2 boton2
	 */
	public Panel(JRadioButton rb1, JRadioButton rb2) {
		Color color= new Color(220, 53, 53);
		Color fondo=new Color(41, 52, 98);
		this.setBackground(fondo);
		ButtonGroup rbGroup = new ButtonGroup();
		rbGroup.add(rb1);
		rbGroup.add(rb2);
		rb1.setSelected(true);
		rb1.setToolTipText("Precio normal");
		rb2.setToolTipText("Descuento por familia numerosa");
		rb2.addActionListener(e->JOptionPane.showMessageDialog(this, "Descuento del 25% aplicado", "Descuento", JOptionPane.INFORMATION_MESSAGE));
		rb1.setForeground(color);
		rb2.setForeground(color);
		rb1.setBackground(fondo);
		rb2.setBackground(fondo);
		this.add(rb1);
		this.add(rb2);
	}
	
	/**
	 * Método para asignar el texto de los TextArea de las pestañas del Panel5.
	 *
	 * @param resumen the new string
	 */
	public void setString(String resumen) {
		taResumen.setText(resumen);
	}
}

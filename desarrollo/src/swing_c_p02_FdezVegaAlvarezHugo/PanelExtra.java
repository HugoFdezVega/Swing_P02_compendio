package swing_c_p02_FdezVegaAlvarezHugo;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

/**
 * Clase PanelExtra.
 * 
 * @author Hugo Fdez-Vega Alvarez
 */
public class PanelExtra extends JPanel implements FocusListener{

	//Declaramos e instanciamos los atributos 
	private JLabel lbEdad=new JLabel("Edad de los niños:");
	private JSpinner spEdad;
	private JLabel lbExtras=new JLabel("Extras:");
	private JTextField tfExtras;
	
	//Declaramos e instanciamos el layout y sus constraints
	private GridBagConstraints constraints = new GridBagConstraints();
	private GridBagLayout layout = new GridBagLayout();
	
	/**
	 * Constructor de PanelExtra.
	 *
	 * @param panelFamiliaNumerosa, donde irán los componentes para el descuento
	 * @param spEdad, donde se elige la edad de los niños
	 * @param tfExtras, que obtiene el tipo de cama según la edad
	 */
	public PanelExtra(Panel panelFamiliaNumerosa, JSpinner spEdad, JTextField tfExtras) {
		//Instancamos los demás atributos con los que nos han llegado por parámetro
		this.spEdad=spEdad;
		this.tfExtras=tfExtras;
		//Declaramos, instanciamos y aplicamos el borde del panel
		Color color= new Color(220, 53, 53);
		Color fondo=new Color(41, 52, 98);
		lbEdad.setForeground(color);
		lbExtras.setForeground(color);
		this.setBackground(fondo);
		// Aplicamos el layout y el formato de las constraints
		this.setLayout(layout);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.weightx = 0; // no puede crecer a lo ancho
		constraints.weighty = 0; // no puede crecer a lo alto
		// Definimos las propiedades de los componentes y los posicionamos
		this.addComponent(lbEdad, 0, 0, 1, 1);
		constraints.weightx = 1; // puede crecer a lo ancho
		this.addComponent(spEdad, 1, 0, 1, 1);
		constraints.weightx = 0; // no puede crecer a lo ancho
		this.addComponent(lbExtras, 2, 0, 1, 1);
		constraints.weightx = 1; // puede crecer a lo ancho
		tfExtras.addFocusListener(this);
		tfExtras.setEditable(false);
		this.addComponent(tfExtras, 3, 0, 1, 1);
		constraints.weightx = 0; // no puede crecer a lo ancho
		this.addComponent(panelFamiliaNumerosa, 0, 1, 4, 1);
		
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

	/**
	 * Evento que se activa al ganar foco.
	 *
	 * @param e evento
	 */
	@Override
	public void focusGained(FocusEvent e) {
		String extras="";
		int edad=(int) spEdad.getValue();
		if(edad<4) {
			extras="Cuna";
		}
		else if(edad>4&&edad<11) {
			extras="Cama supletoria pequeña";
		}
		else {
			extras="Cama supletoria normal";
		}
		tfExtras.setText(extras);
	}

	/**
	 * Evento que se activa al perder el foc.
	 *
	 * @param e evento
	 */
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

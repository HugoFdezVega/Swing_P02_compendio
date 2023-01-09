/**
 * Swing_c_p01_parte1_fdezVegaAlvarezHugo-swing_c_p01_parte1_fdezVegaAlvarezHugo-VentanaAltas.java
 * 21 nov 2022 9:51:43
 * @author Hugo Fdez-Vega Alvarez
 */
package swing_c_p02_FdezVegaAlvarezHugo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * Clase VentanaAltas.
 *
 * @author Hugo Fdez-Vega Alvarez
 */
public class VentanaAltas extends JDialog{

	// Declaramos e instanciamos los paneles con sus parámetros
	private Panel1 panel1=new Panel1();
	private Panel2 panel2=new Panel2();
	private Panel3 panel3=new Panel3();
	private Panel4 panel4;
	private Panel5 panel5;
	private JTextArea taResDatos=new JTextArea();
	private JTextArea taResHabitacion=new JTextArea();
	private Panel panelResDatos=new Panel(taResDatos);
	private Panel panelResHabitacion=new Panel(taResHabitacion);
	private JButton btImprimir=new JButton();
	private JButton btNuevo=new JButton();
	private JButton btGuardar=new JButton();

	// Instanciamos el layout y su constraints
	private GridBagConstraints constraints = new GridBagConstraints();
	private GridBagLayout layout = new GridBagLayout();
	
	/**
	 * Constructor de VentanaAltas.
	 *
	 * @param ventana ventana asignada
	 * @param modal true
	 */
	public VentanaAltas(Ventana ventana, boolean modal) {
		// Aplicamos el layout, el formato de las constraints y los atributos del JDialog
		super(ventana, modal);
		this.setTitle("Alta reservas");
		setLocationRelativeTo(null);
		this.setLayout(layout);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1; // puede crecer a lo ancho
		constraints.weighty = 1; // puede crecer a lo alto
		// Obtenemos las dimensiones de la pantalla
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension tamanioPantalla = pantalla.getScreenSize();
		int anchoPantalla = tamanioPantalla.width;
		int altoPantalla = tamanioPantalla.height;
		// Redimensionamos la ventana al total de la resolución de pantalla
		this.setSize((int) (anchoPantalla), (int) (altoPantalla*0.95 ));
		// Colocamos la ventana
		this.setLocation(0,0);
		// Creamos y agregamos el icono de la ventana
		try {
			Image icono = ImageIO.read(getClass().getResource("recursos/icono.png"));
			this.setIconImage(icono);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Agregamos los paneles
		this.addComponent(panel1, 0, 0, 2, 1);
		this.addComponent(panel2, 0, 1, 1, 1);
		this.addComponent(panel3, 1, 1, 1, 2);
		panel4=new Panel4(panelResDatos,panelResHabitacion);
		this.addComponent(panel4, 0, 2, 1, 1);
		constraints.weighty = 0; // no puede crecer a lo alto
		//Añadimos los listeners a los botones
		btImprimir.addActionListener(e->imprimir());
		btNuevo.addActionListener(e->limpiar());
		btGuardar.addActionListener(e->guardar());
		panel5=new Panel5(btImprimir,btNuevo,btGuardar);
		this.addComponent(panel5, 0, 3, 2, 1);
	}

	/**
	 * Imprimir(), que escribe los datos recibidos en sus JTextArea respectivos.
	 */
	private void imprimir() {
		if(!panel2.checkErrors()) {
			List<String> listaDatosPersonales=panel2.getDatosPersonales();
			String strDatosPersonales="Nombre: "+listaDatosPersonales.get(0)+"\n"
					+ "Apellidos: "+listaDatosPersonales.get(1)+"\n"
					+ "Teléfono: "+listaDatosPersonales.get(2)+"\n"
					+ "DNI: "+listaDatosPersonales.get(3)+"\n"
					+ "Fecha de entrada: "+listaDatosPersonales.get(4)+"\n"
					+ "Fecha de salida: "+listaDatosPersonales.get(5)+"\n"
					+ "Total días estancia: "+listaDatosPersonales.get(6)+"\n";
			panelResDatos.setString(strDatosPersonales);
			List<String> listaHabitacion=panel3.getDatosHabitacion();
			String strHabitacion="Tipo de habitación: "+listaHabitacion.get(0)+"\n"
					+ "Número de habitaciones: "+listaHabitacion.get(1)+"\n";
			if(listaHabitacion.size()>3) {
				strHabitacion+="Niños: Sí\n"
						+ "Edad de los niños: "+listaHabitacion.get(2)+"\n"
						+ "Cama de los niños: "+listaHabitacion.get(3)+"\n"
						+ "Precio final: "+listaHabitacion.get(4)+"€\n";
			} else {
				strHabitacion+="Niños: No\n"
						+ "Precio final: "+listaHabitacion.get(2)+"€\n";
			}
			panelResHabitacion.setString(strHabitacion);
		}
	}
	
	/**
	 * Método Limpiar() que inicializa todos los componentes desde el principio.
	 */
	public void limpiar() {
		panel2.limpiar();
		panel3.limpiar();
		panelResDatos.setString("");
		panelResHabitacion.setString("");
	}
	
	/**
	 * Guardar(), que comprueba que todo esté bien y muestra un mensaje indicando que se guardó la reserva.
	 */
	public void guardar() {
		if(!panel2.checkErrors()) {
			JOptionPane.showMessageDialog(this, "Felicidades, su reserva se ha guardado correctamente. Esperamos verles pronto.", "¡Conseguido!", JOptionPane.INFORMATION_MESSAGE);
		}
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

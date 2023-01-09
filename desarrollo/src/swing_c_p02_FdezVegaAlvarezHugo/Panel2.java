/**
 * Swing_c_p02_FdezVegaAlvarezHugo-swing_c_p02_FdezVegaAlvarezHugo-Panel2.java
 * 21 nov 2022 11:36:10
 * @author Hugo Fdez-Vega Alvarez
 */
package swing_c_p02_FdezVegaAlvarezHugo;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

/**
 * Clase Panel2.
 *
 * @author Hugo Fdez-Vega Alvarez
 */
public class Panel2 extends JPanel {

	JLabel lbNombre;
	JLabel lbApellidos;
	JLabel lbTlf;
	JLabel lbDNI;
	JLabel lbFechaEntrada;
	JLabel lbFechaSalida;
	JLabel lbDiasEstancia;
	JLabel lbEstanciaCalculada;
	MaskFormatter maskDNI;
	MaskFormatter maskTlf;
	JFormattedTextField tfTlf;
	JFormattedTextField tfDNI;
	JTextField tfNombre;
	JTextField tfApellidos;
	JTextField tfFechaEntrada;
	JTextField tfFechaSalida;
	
	//Declaramos e instanciamos el layout y sus constraints
	private GridBagConstraints constraints = new GridBagConstraints();
	private GridBagLayout layout = new GridBagLayout();

	/**
	 * Constructor del Panel2.
	 */
	public Panel2() {
		//Declaramos, instanciamos y aplicamos el borde del panel
		Color color=new Color(244, 157, 26);
		Color fondo=new Color(41, 52, 98);
		Border borde = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(color, 2),"Datos personales", TitledBorder.CENTER, TitledBorder.TOP, null, color);
		this.setBorder(borde);
		this.setBackground(fondo);
		// Aplicamos el layout y el formato de las constraints
		this.setLayout(layout);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.weightx = 0; // no puede crecer a lo ancho
		constraints.weighty = 0; // no puede crecer a lo alto
		// Creamos las máscaras para los formatos
		try {
			maskDNI = new MaskFormatter("########U");
			maskTlf = new MaskFormatter("#########");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		/* Definimos las propiedades de los componentes */
		// Primera fila
		lbNombre = new JLabel("Nombre: ");
		lbNombre.setForeground(color);
		this.addComponent(lbNombre, 0, 0, 1, 1);
		constraints.weightx = 1; // puede crecer a lo ancho
		tfNombre = new JTextField();
		this.addComponent(tfNombre, 1, 0, 1, 1);
		constraints.weightx = 0; // no puede crecer a lo ancho
		lbFechaEntrada = new JLabel("Fecha de entrada:");
		lbFechaEntrada.setForeground(color);
		this.addComponent(lbFechaEntrada, 2, 0, 1, 1);
		constraints.weightx = 1; // puede crecer a lo ancho
		tfFechaEntrada = new JTextField();
		this.addComponent(tfFechaEntrada, 3, 0, 1, 1);
		constraints.weightx = 0; // no puede crecer a lo ancho
		// Segunda fila
		lbApellidos = new JLabel("Apellidos: ");
		lbApellidos.setForeground(color);
		this.addComponent(lbApellidos, 0, 1, 1, 1);
		tfApellidos = new JTextField();
		this.addComponent(tfApellidos, 1, 1, 1, 1);
		lbFechaSalida = new JLabel("Fecha de salida:");
		lbFechaSalida.setForeground(color);
		this.addComponent(lbFechaSalida, 2, 1, 1, 1);
		tfFechaSalida = new JTextField();
		this.addComponent(tfFechaSalida, 3, 1, 1, 1);
		// Tercera fila
		lbDNI = new JLabel("DNI: ");
		lbDNI.setForeground(color);
		this.addComponent(lbDNI, 0, 2, 1, 1);
		tfDNI = new JFormattedTextField(maskDNI);
		tfDNI.setFocusLostBehavior(tfDNI.COMMIT);
		tfDNI.setToolTipText("8 números y una letra");
		this.addComponent(tfDNI, 1, 2, 1, 1);
		lbDiasEstancia = new JLabel("Dias de estancia:");
		lbDiasEstancia.setForeground(color);
		this.addComponent(lbDiasEstancia, 2, 2, 1, 1);
		lbEstanciaCalculada = new JLabel("");
		lbEstanciaCalculada.setForeground(color);
		this.addComponent(lbEstanciaCalculada, 3, 2, 1, 1);
		setFechas();
		// Cuarta fila y empujón final
		lbTlf = new JLabel("Teléfono: ");
		lbTlf.setForeground(color);
		this.addComponent(lbTlf, 0, 3, 1, 1);
		tfTlf = new JFormattedTextField(maskTlf);
		tfTlf.setFocusLostBehavior(tfTlf.COMMIT);
		this.addComponent(tfTlf, 1, 3, 1, 1);
//		JLabel empujon=new JLabel();
//		constraints.weightx = 1; // puede crecer a lo ancho
//		constraints.weighty = 1; // puede crecer a lo alto
//		this.addComponent(empujon, 0, 4, 4, 1);
	}

	/**
	 * Método setFechas() que establece la fecha actual, la siguiente y los días entre una y otra.
	 */
	public void setFechas() {
		LocalDate fechaPresente = LocalDate.now(); // <-- Obtenemos la fecha presente
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // <-- Creamos un formato para la fecha
		String fechaFormateada = fechaPresente.format(formato); // <-- Obtenemos la fecha formateada
		tfFechaEntrada.setText(fechaFormateada);
		LocalDate fechaSiguiente = fechaPresente.plusDays(1); // <-- Obtenemos la fecha de mañana
		String fechaManianaFormateada = fechaSiguiente.format(formato); // <-- Obtenemos la fecha formateada
		tfFechaSalida.setText(fechaManianaFormateada);
		Long diferenciaFechas = ChronoUnit.DAYS.between(fechaPresente, fechaSiguiente); // <-- Obtenemos la diferencia entre las fechas
		lbEstanciaCalculada.setText(String.valueOf(diferenciaFechas));
	}

	/**
	 * Método checkErrors, que comprobará que todos los campos estén rellenos.
	 *
	 * @return si hay errores o no
	 */
	public boolean checkErrors() {
		boolean error = false;
		if (tfNombre.getText().trim().isEmpty()) {
			lanzarError("El campo nombre no puede estar vacío");
			error = true;
		}
		if (tfFechaEntrada.getText().trim().isEmpty()) {
			lanzarError("El campo para la fecha de entrada no puede estar vacío");
			error = true;
		}
		if (tfApellidos.getText().trim().isEmpty()) {
			lanzarError("El campo apellidos no puede estar vacío");
			error = true;
		}
		if (tfFechaSalida.getText().trim().isEmpty()) {
			lanzarError("El campo para la fecha de salida no puede estar vacío");
			error = true;
		}
		if (tfDNI.getText().trim().isEmpty()) {
			lanzarError("El campo DNI no puede estar vacío");
			error = true;
		}
		if (tfTlf.getText().trim().isEmpty()) {
			lanzarError("El campo teléfono no puede estar vacío");
			error = true;
		}
		return error;
	}

	/**
	 * Método lanzarError() para crear los JOptionPane de los errores.
	 *
	 * @param error que saldrá por pantalla
	 */
	public void lanzarError(String error) {
		JOptionPane.showMessageDialog(this, error, "Error en Datos personales", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Método getDatosPersonales().
	 *
	 * @return lista con los datos personales
	 */
	public List<String> getDatosPersonales() {
		List<String> datosPersonales = new ArrayList<>();
		datosPersonales.add(tfNombre.getText());
		datosPersonales.add(tfApellidos.getText());
		datosPersonales.add(tfTlf.getText());
		datosPersonales.add(tfDNI.getText());
		datosPersonales.add(tfFechaEntrada.getText());
		datosPersonales.add(tfFechaSalida.getText());
		datosPersonales.add(lbEstanciaCalculada.getText());
		return datosPersonales;
	}
	
	/**
	 * Método Limpiar() que inicializa todos los componentes desde el principio.
	 */
	public void limpiar() {
		tfNombre.setText("");;
		tfApellidos.setText("");
		tfTlf.setText("");
		tfDNI.setText("");
		setFechas();
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

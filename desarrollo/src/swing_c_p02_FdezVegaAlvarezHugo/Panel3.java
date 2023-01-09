package swing_c_p02_FdezVegaAlvarezHugo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * Clase Panel3.
 * 
 * @author Hugo Fdez-Vega Alvarez
 */
public class Panel3 extends JPanel implements FocusListener{
	
	//Declaramos e instanciamos los objetos necesarios para esta clase y sus subpaneles
	private JLabel lbTipo=new JLabel("Tipo de habitación:");
	private String[] opciones = { "Simple", "Doble", "Suite"};
	private JComboBox<String> combo = new JComboBox(opciones);
	private JLabel lbNumHabitaciones=new JLabel("Número de habitaciones:");
	private SpinnerModel modelo = new SpinnerNumberModel(1, 1, 50, 1);
	private JSpinner spinner = new JSpinner(modelo);
	private JCheckBox cbNinios = new JCheckBox("Niños");
	private PanelExtra panelExtra;
	private SpinnerModel modeloEdad = new SpinnerNumberModel(0, 0, 14, 1);
	private JSpinner spEdad = new JSpinner(modeloEdad);
	private JTextField tfExtras=new JTextField();
	private Panel panelInicial=new Panel();
	private JTextField tfPrecio=new JTextField();
	private JRadioButton rbFamiliaStandard = new JRadioButton("Dos hijos o menos");
	private JRadioButton rbFamiliaNumerosa = new JRadioButton("Más de dos hijos");
	private Panel panelFamiliaNumerosa=new Panel(rbFamiliaStandard,rbFamiliaNumerosa);

	//Declaramos e instanciamos el layout y sus constraints
	private GridBagConstraints constraints = new GridBagConstraints();
	private GridBagLayout layout = new GridBagLayout();
	
	/**
	 * Constructor del Panel3.
	 */
	public Panel3() {
		//Declaramos e instanciamos las imágenes y se las pasamos a sus respectivas labels
		ImageIcon img1 = new ImageIcon(getClass().getResource("recursos/habitacion1.jpg"));
		ImageIcon img2 = new ImageIcon(getClass().getResource("recursos/habitacion2.jpg"));
		ImageIcon img3 = new ImageIcon(getClass().getResource("recursos/habitacion3.jpg"));
		ImageIcon img4 = new ImageIcon(getClass().getResource("recursos/habitacion4.jpg"));
		JLabel lbImg1 = new JLabel(img1);
		JLabel lbImg2 = new JLabel(img2);
		JLabel lbImg3 = new JLabel(img3);
		JLabel lbImg4 = new JLabel(img4);
		//Declaramos, instanciamos y aplicamos el borde del panel
		Color color= new Color(220, 53, 53);
		Color fondo=new Color(41, 52, 98);
		Border borde = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(color, 2), "Seleccione su habitación", TitledBorder.CENTER, TitledBorder.TOP, null, color);
		this.setBorder(borde);
		this.setBackground(fondo);
		panelInicial.setBackground(fondo);
		lbTipo.setForeground(color);
		lbNumHabitaciones.setForeground(color);
		cbNinios.setForeground(color);
		cbNinios.setBackground(fondo);
		// Aplicamos el layout y el formato de las constraints
		this.setLayout(layout);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.weightx = 0; // no puede crecer a lo ancho
		constraints.weighty = 0; // no puede crecer a lo alto
		//Agregamos al panel inicial sus componentes y lo posicionamos
		panelInicial.add(lbTipo);
		panelInicial.add(combo);
		panelInicial.add(lbNumHabitaciones);
		panelInicial.add(spinner);
		panelInicial.add(cbNinios);
		this.addComponent(panelInicial, 0, 0, 4, 1);
		cbNinios.addActionListener(e->abrirPanelExtra());
		//Instanciamos el panel extra con sus parámetros para controlarlos y lo posicionamos
		panelExtra=new PanelExtra(panelFamiliaNumerosa,spEdad,tfExtras);
		panelExtra.setVisible(false);
		this.addComponent(panelExtra, 0, 1, 4, 1);
		//Aplicamos los atributos a tfPrecio y lo posicionamos
		Font fuentePrecio=new Font(tfPrecio.getFont().getName(),Font.BOLD,tfPrecio.getFont().getSize());
		tfPrecio.setHorizontalAlignment(JTextField.CENTER);
		tfPrecio.setFont(fuentePrecio);
		tfPrecio.setText("Pulse aquí para mostrar el precio final");
		tfPrecio.addFocusListener(this);
		tfPrecio.setEditable(false);
		this.addComponent(tfPrecio, 1, 2, 2, 1);
		//Posicionamos las imágenes
		this.addComponent(lbImg1, 0, 3, 1, 1);
		this.addComponent(lbImg2, 1, 3, 1, 1);
		this.addComponent(lbImg3, 2, 3, 1, 1);
		this.addComponent(lbImg4, 3, 3, 1, 1);	
	}
	
	/**
	 * Método que gestiona la visibilidad de PanelExtra.
	 */
	private void abrirPanelExtra() {
		if(cbNinios.isSelected()){
			panelExtra.setVisible(true);
		} else {
			panelExtra.setVisible(false);
		}
	}
	
	/**
	 * Método getImporteHabitacion(), que calcula el importe final.
	 *
	 * @return precio de la habitación
	 */
	private int getImporteHabitacion() {
		int precioHabitacion=0;
		int numHabitaciones=0;
		int multiplicadorHabitacion=0;
		if(combo.getSelectedIndex()==0) {
			multiplicadorHabitacion=50;
		}
		else if(combo.getSelectedIndex()==1) {
			multiplicadorHabitacion=75;
		}
		else {
			multiplicadorHabitacion=125;
		}
		numHabitaciones=(int) spinner.getValue();
		precioHabitacion=numHabitaciones*multiplicadorHabitacion;
		if(cbNinios.isSelected()) {
			precioHabitacion+=20;
			if(rbFamiliaNumerosa.isSelected()) {
				precioHabitacion=(int) (precioHabitacion*0.75);
			}
		}
		return precioHabitacion;
	}
	
	/**
	 * Método getDatosHabitation().
	 *
	 * @return lista con los datos de la habitación
	 */
	public List<String> getDatosHabitacion(){
		List<String> datosHabitacion = new ArrayList<>();
		int indice=combo.getSelectedIndex();
		if(indice==0) {
			datosHabitacion.add("Simple");
		}
		else if(indice==1) {
			datosHabitacion.add("Doble");
		}
		else {
			datosHabitacion.add("Suite");
		}
		int indexSpinner=(int) spinner.getValue();
		datosHabitacion.add(String.valueOf(indexSpinner));
		if(cbNinios.isSelected()) {
			int indexEdad=(int) spEdad.getValue();
			datosHabitacion.add(String.valueOf(indexEdad));
			if(indexEdad<4) {
				datosHabitacion.add("Cuna");
			}
			else if(indexEdad>4&&indexEdad<11) {
				datosHabitacion.add("Cama supletoria pequeña");
			}
			else {
				datosHabitacion.add("Cama supletoria normal");
			}
		}
		int precio=getImporteHabitacion();
		datosHabitacion.add(String.valueOf(precio));
		return datosHabitacion;
	}
	
	/**
	 * Método Limpiar() que inicializa todos los componentes desde el principio.
	 */
	public void limpiar() {
		combo.setSelectedIndex(0);
		spinner.setValue(1);
		spEdad.setValue(0);
		rbFamiliaStandard.setSelected(true);
		cbNinios.setSelected(false);
		panelExtra.setVisible(false);
		tfPrecio.setText("Pulse aquí para mostrar el precio final");
		tfExtras.setText("");
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
	 * Focus gained.
	 *
	 * @param e the e
	 */
	@Override
	public void focusGained(FocusEvent e) {
		String precioFinal="El precio final de su reserva es de: "+getImporteHabitacion()+"€";
		tfPrecio.setText(precioFinal);
		
	}

	/**
	 * Focus lost.
	 *
	 * @param e the e
	 */
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}

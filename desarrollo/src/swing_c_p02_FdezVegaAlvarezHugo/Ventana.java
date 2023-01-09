/**
 * Swing_c_p02_FdezVegaAlvarezHugo-swing_c_p02_FdezVegaAlvarezHugo-Ventana.java
 * 21 nov 2022 9:19:08
 * @author Hugo Fdez-Vega Alvarez
 */
package swing_c_p02_FdezVegaAlvarezHugo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase Ventana.
 *
 * @author Hugo Fdez-Vega Alvarez
 */
public class Ventana extends JFrame implements ActionListener {

	private JMenuBar miBarra;
	private JMenu archivo, registro, ayuda;
	private JMenuItem salir, altaReservas, bajaReservas, acercaDe;
	private Ventana ventana;
	private JButton btAlta, btBaja;
	ImageIcon imgAlta=new ImageIcon(getClass().getResource("recursos/alta.png"));
	ImageIcon imgBaja=new ImageIcon(getClass().getResource("recursos/baja.png"));

	/**
	 * Constructor de Ventana.
	 */
	public Ventana() {
		super("Gestión Hotel 'Paraíso'");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Obtenemos las dimensiones de la pantalla
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension tamanioPantalla = pantalla.getScreenSize();
		int anchoPantalla = tamanioPantalla.width;
		int altoPantalla = tamanioPantalla.height;
		// Redimensionamos la ventana a la mitad de la resolución de la pantalla
		this.setSize((int) (anchoPantalla * 0.5), (int) (altoPantalla * 0.5));
		// Colocamos la ventana en la mitad de la pantalla
		this.setLocation(anchoPantalla / 4, altoPantalla / 4);
		// Creamos y agregamos el icono de la ventana
		try {
			Image icono = ImageIO.read(getClass().getResource("recursos/icono.png"));
			this.setIconImage(icono);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Creamos los botones y los posicionamos
		btAlta=new JButton();
		btAlta.addActionListener(this);
		btAlta.setBounds(300, 50, 100, 100);
		btAlta.setIcon(imgAlta);
		btAlta.setMnemonic(KeyEvent.VK_A);
		btBaja=new JButton();
		btBaja.addActionListener(this);
		btBaja.setBounds(500, 50, 100, 100);
		btBaja.setIcon(imgBaja);
		btBaja.setMnemonic(KeyEvent.VK_B);
		//Colocamos los botones
		Panel panel= new Panel();
		panel.setLayout(null);
		panel.add(btAlta);
		panel.add(btBaja);
		this.getContentPane().add(panel);
		//Colocamos la barra del menú
		colocarMenuBar();
	}

	/**
	 * Coloca la barra de menú.
	 */
	private void colocarMenuBar() {
		// Instanciamos la barra de menú
		miBarra = new JMenuBar();
		// Instanciamos los menús de la barra
		archivo = new JMenu("Archivo");
		registro = new JMenu("Registro");
		ayuda = new JMenu("Ayuda");
		// Instanciamos las opciones de los menús
		salir = new JMenuItem ("Salir");
		altaReservas = new JMenuItem ("Alta de revervas");
		bajaReservas = new JMenuItem("Baja de reservas");
		acercaDe = new JMenuItem("Acerca de...");
		// Agreamos las opciones a los menús
		archivo.add(salir);
		registro.add(altaReservas);
		registro.add(bajaReservas);
		ayuda.add(acercaDe);
		// Agregamos los menús a la barra
		miBarra.add(archivo);
		miBarra.add(registro);
		miBarra.add(ayuda);
		// Agreamos la barra a la ventana
		this.setJMenuBar(miBarra);
		// Añadimos los listeners
		salir.addActionListener(this);
		altaReservas.addActionListener(this);
		bajaReservas.addActionListener(this);
		acercaDe.addActionListener(this);
		registro.setMnemonic(KeyEvent.VK_S);
	}
	
	/**
	 * Coloca la Ventana.
	 *
	 * @param ventana ventana que se asigna
	 */
	public void setVentana(Ventana ventana) {
		this.ventana=ventana;
	}

	/**
	 * Evento que se activa al pulsar
	 *
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==salir) {
			System.exit(0);
		}
		else if(e.getSource()==altaReservas||e.getSource()==btAlta) {
			abrirAltas(ventana);
		}
		else if(e.getSource()==bajaReservas||e.getSource()==btBaja) {
			enConstruccion();
		}
		else if (e.getSource()==acercaDe) {
			String info="Empresa: Hotel paraíso\n"
					+ "NIF: 39788325G\n"
					+ "Empresa fundada en 1957 por Mariano Alcantara\n"
					+ "Email: paraisoreservas@gmail.com\n"
					+ "Teléfono: 950597412";
			JOptionPane.showMessageDialog(this, info, "Sobre nosotros", JOptionPane.PLAIN_MESSAGE);
		}

	}

	/**
	 * Abrir altas.
	 *
	 * @param Ventana
	 */
	private void abrirAltas(Ventana ventana) {
		VentanaAltas altas= new VentanaAltas(ventana, true);
		altas.setVisible(true);
	}
	
	/**
	 * En construccion.
	 */
	private void enConstruccion() {
		JOptionPane.showMessageDialog(this, "Está función estará disponible próximamente. Disculpe las molestias.", "En construcción", JOptionPane.INFORMATION_MESSAGE);
	}

}

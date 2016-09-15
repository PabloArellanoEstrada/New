import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;

////@ Project : Ejercicio Avion
//@ Date : 02/09/2016
//@ Author : Pablo Arellano

public class GUIAviones {

	private JFrame frame;
	private JTextField tfFabricante;
	private JTextField tfModelo;
	private JTextField tfAlcance;
	
	private JButton btnAgregar;
	private JButton btnCalcular;
	private JPanel  pResultados;
	
	private JLabel lblResultados;
	private JLabel lblCalculos;
	private JLabel lblError;
	
	
	private GestionAvion gestionAvion;
	private int cont;
	private String cadena;
	private JTextField MostrarUnico;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAviones window = new GUIAviones();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIAviones() {
		initialize();
		gestionAvion = new GestionAvion();
		cont=0;
		cadena = "<html><body>Usted agregó los siguientes aviones: ";
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblFabricante = new JLabel("Fabricante :");
		lblFabricante.setBounds(10, 39, 131, 20);
		JLabel lblModelo = new JLabel("Modelo :");
		lblModelo.setBounds(10, 61, 118, 20);
		JLabel lblAlcance = new JLabel("Alcance :");
		lblAlcance.setBounds(10, 83, 118, 22);
		
		tfFabricante = new JTextField();
		tfFabricante.setBounds(167, 40, 155, 20);
		tfFabricante.setColumns(10);
		
		tfModelo = new JTextField();
		tfModelo.setBounds(167, 62, 155, 20);
		tfModelo.setColumns(10);
		
		tfAlcance = new JTextField();
		tfAlcance.setBounds(167, 84, 155, 20);
		tfAlcance.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(202, 127, 89, 23);
		btnAgregar.addActionListener(new MiBotonListener());
		
		btnCalcular = new JButton("Mostrar");
		btnCalcular.setBounds(202, 380, 89, 23);
		btnCalcular.addActionListener(new MiBotonListener());
		btnCalcular.setVisible(false);
		
		pResultados = new JPanel();
		pResultados.setBounds(332, 13, 242, 356);
		pResultados.setLayout(new BorderLayout(0, 0));
		
		lblResultados = new JLabel(" ");
		pResultados.add(lblResultados, BorderLayout.NORTH);
		
		lblCalculos = new JLabel(" ");
		pResultados.add(lblCalculos, BorderLayout.SOUTH);
		
		//Se agregan todos los componentes al panel
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblFabricante);
		frame.getContentPane().add(lblModelo);
		frame.getContentPane().add(lblAlcance);
		frame.getContentPane().add(tfFabricante);
		frame.getContentPane().add(tfModelo);
		frame.getContentPane().add(tfAlcance);
		frame.getContentPane().add(btnAgregar);
		frame.getContentPane().add(btnCalcular);
		frame.getContentPane().add(pResultados);
		
		MostrarUnico = new JTextField();
		MostrarUnico.setBounds(167, 349, 155, 20);
		frame.getContentPane().add(MostrarUnico);
		MostrarUnico.setColumns(10);
		
		JLabel lblAvionDeseaVer = new JLabel("Que avion desea ver: ");
		lblAvionDeseaVer.setBounds(24, 355, 120, 14);
		frame.getContentPane().add(lblAvionDeseaVer);
				
	}
	
	public void limpiar() {
		tfFabricante.setText(null);
		tfModelo.setText(null);
		tfAlcance.setText(null);
	}
	
	public boolean vacios() {
		boolean resultado = false;
		if (tfFabricante.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Debe ingresar fabricante");
		return resultado;
	}
	
	/**
	 * @return boolean
	 *  true si todos los campos tienen info
	 *  false si al menos uno esta vacio
	 */
	public boolean noVacios(){
		boolean result = true;
		//Si todos los campos tienen textos se devuelve true
		if (tfFabricante.getText().equals("") && tfModelo.getText().equals("") && tfAlcance.getText().equals(""))
			result = false;
		return result;
	}
	
	/**
	 * @param num: String
	 * @return boolean
	 * Si es un numero devuelve true
	 * Si NO es un numero muestra un error y devuelve false
	 */
	public boolean esNumero(String num){
		boolean result = false;
		try{
			Double.parseDouble(num); //Se intenta convertir
			result = true; //Si se pudo se pone el resultado en true
		}
		catch (Exception e){ //Si no se pudo convertir
			//Se muestra el mensaje de error
			JOptionPane.showMessageDialog(null, num+" Falta un numero", "Ingrese números", JOptionPane.ERROR_MESSAGE);
		}
		return result;
	}
	private class MiBotonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == btnAgregar){
				if (noVacios()){
					if (esNumero(tfAlcance.getText()) ){
						
						cadena = cadena + "<br><br>Avion"+(cont+1)+": ";
						cadena = cadena + tfFabricante.getText() + ", "+tfModelo.getText() + ", "+tfAlcance.getText();
						int tfAlcance1 = Integer.parseInt(tfAlcance.getText());
						gestionAvion.llenarAvion(tfFabricante.getText(), tfModelo.getText(), tfAlcance1);
						lblResultados.setText(cadena);
						limpiar();
						btnCalcular.setVisible(true); // muestra el avion elegido hasta que esten los 10 objetos ingresados
						cont++;
						if(cont == 10){
							tfFabricante.setEnabled(false);
							tfModelo.setEnabled(false);
							tfAlcance.setEditable(false);
							btnAgregar.setEnabled(false);
							cadena = cadena+"</body></html>";
						}
						
						limpiar();//limpia los textfields
					}
				}
				else{
					lblError.setText("Debe ingresar datos en los campos de texto");
					lblError.setVisible(true);
				}
				
			}
			//double prom = gestion.calcularPromedio();
			if (e.getSource() == btnCalcular){
				int MostrarUnico1 = Integer.parseInt(MostrarUnico.getText());
				String impresion = gestionAvion.toString(MostrarUnico1);
				lblCalculos.setText("Avion: "+impresion);
				limpiar();//limpia los textfields
			}
			
		}
		
	}
}

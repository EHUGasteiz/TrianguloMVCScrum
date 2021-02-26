package es.ehu.eui.triangulo.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import es.ehu.eui.triangulo.model.TrianguloRectangulo;

public class VentanaTrianguloTexto extends JFrame implements Observer {

	private static final long serialVersionUID = 3076804824806109438L;
	private JPanel contentPane;
	private JPanel pnlDatosTriangulo;
	private JLabel lblBase;
	private JTextField txtBase;
	private JLabel lblAltura;
	private JTextField txtAltura;
	private JLabel lblHipotenusa;
	private JTextField txtHipotenusa;
	private Controlador controlador;
	private TrianguloRectangulo modelo;
	


	/**
	 * Crea una nueva ventana
	 * @param pTriangulo - el triangulo que se refleja en la ventana
	 */
	public VentanaTrianguloTexto(TrianguloRectangulo pTriangulo) {
		initialize();
		modelo = pTriangulo;
		modelo.addObserver(this);
		update(modelo, null);
	}
	
	private void initialize() {
		setResizable(false);
		setTitle("Vista 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnlDatosTriangulo(), BorderLayout.CENTER);
	}

	/**
	 * Actualiza la informacion mostrada en la ventana
	 * {@see java.util.Observer}
	 */
	public void update(Observable observable, Object arg) {
		 	// La vista solo observa a un triangulo (modelo)
		    getTxtBase().setText(String.valueOf(modelo.getBase()));
		    getTxtAltura().setText(String.valueOf(modelo.getAltura()));
		    getTxtHipotenusa().setText(String.valueOf(modelo.getHipotenusa()));
	}

	private JPanel getPnlDatosTriangulo() {
		if (pnlDatosTriangulo == null) {
			pnlDatosTriangulo = new JPanel();
			pnlDatosTriangulo.setBorder(new EmptyBorder(10, 10, 10, 10));
			GridBagLayout gbl_pnlDatosTriangulo = new GridBagLayout();
			gbl_pnlDatosTriangulo.columnWidths = new int[] { 0, 0, 0 };
			gbl_pnlDatosTriangulo.rowHeights = new int[] { 0, 0, 0, 0 };
			gbl_pnlDatosTriangulo.columnWeights = new double[] { 0.0, 1.0,
					Double.MIN_VALUE };
			gbl_pnlDatosTriangulo.rowWeights = new double[] { 0.0, 0.0, 0.0,
					Double.MIN_VALUE };
			pnlDatosTriangulo.setLayout(gbl_pnlDatosTriangulo);
			GridBagConstraints gbc_lblBase = new GridBagConstraints();
			gbc_lblBase.anchor = GridBagConstraints.WEST;
			gbc_lblBase.insets = new Insets(0, 0, 5, 5);
			gbc_lblBase.gridx = 0;
			gbc_lblBase.gridy = 0;
			pnlDatosTriangulo.add(getLblBase(), gbc_lblBase);
			GridBagConstraints gbc_txtBase = new GridBagConstraints();
			gbc_txtBase.insets = new Insets(0, 0, 5, 0);
			gbc_txtBase.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtBase.gridx = 1;
			gbc_txtBase.gridy = 0;
			pnlDatosTriangulo.add(getTxtBase(), gbc_txtBase);
			GridBagConstraints gbc_lblAltura = new GridBagConstraints();
			gbc_lblAltura.anchor = GridBagConstraints.WEST;
			gbc_lblAltura.insets = new Insets(0, 0, 5, 5);
			gbc_lblAltura.gridx = 0;
			gbc_lblAltura.gridy = 1;
			pnlDatosTriangulo.add(getLblAltura(), gbc_lblAltura);
			GridBagConstraints gbc_txtAltura = new GridBagConstraints();
			gbc_txtAltura.insets = new Insets(0, 0, 5, 0);
			gbc_txtAltura.anchor = GridBagConstraints.NORTH;
			gbc_txtAltura.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAltura.gridx = 1;
			gbc_txtAltura.gridy = 1;
			pnlDatosTriangulo.add(getTxtAltura(), gbc_txtAltura);
			GridBagConstraints gbc_lblHipotenusa = new GridBagConstraints();
			gbc_lblHipotenusa.anchor = GridBagConstraints.WEST;
			gbc_lblHipotenusa.insets = new Insets(0, 0, 0, 5);
			gbc_lblHipotenusa.gridx = 0;
			gbc_lblHipotenusa.gridy = 2;
			pnlDatosTriangulo.add(getLblHipotenusa(), gbc_lblHipotenusa);
			GridBagConstraints gbc_txtHipotenusa = new GridBagConstraints();
			gbc_txtHipotenusa.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHipotenusa.gridx = 1;
			gbc_txtHipotenusa.gridy = 2;
			pnlDatosTriangulo.add(getTxtHipotenusa(), gbc_txtHipotenusa);
		}
		return pnlDatosTriangulo;
	}

	private JLabel getLblBase() {
		if (lblBase == null) {
			lblBase = new JLabel("Base:");
			lblBase.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		}
		return lblBase;
	}

	private JTextField getTxtBase() {
		if (txtBase == null) {
			txtBase = new JTextField();
			txtBase.setActionCommand("base");
			txtBase.setColumns(10);
			txtBase.addActionListener(getControlador());
		}
		return txtBase;
	}

	private JLabel getLblAltura() {
		if (lblAltura == null) {
			lblAltura = new JLabel("Altura:");
			lblAltura.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		}
		return lblAltura;
	}

	private JTextField getTxtAltura() {
		if (txtAltura == null) {
			txtAltura = new JTextField();
			txtAltura.setActionCommand("altura");
			txtAltura.setColumns(10);
			txtAltura.addActionListener(getControlador());
		}
		return txtAltura;
	}

	private JLabel getLblHipotenusa() {
		if (lblHipotenusa == null) {
			lblHipotenusa = new JLabel("Hipotenusa:");
			lblHipotenusa.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		}
		return lblHipotenusa;
	}

	private JTextField getTxtHipotenusa() {
		if (txtHipotenusa == null) {
			txtHipotenusa = new JTextField();
			txtHipotenusa.setEditable(false);
			txtHipotenusa.setColumns(10);
		}
		return txtHipotenusa;
	}

	private Controlador getControlador() {
		if (controlador == null) {
			controlador = new Controlador();
		}
		return controlador;
	}

	private class Controlador implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JTextField tf = (JTextField) e.getSource();
			try {
				int valor = Integer.parseInt(tf.getText());
				if (valor < 0)
					throw new NumberFormatException();
				String cual = e.getActionCommand();
				if (cual.equals("base"))
					modelo.setBase(valor);
				else
					modelo.setAltura(valor);
			} catch (NumberFormatException ex) {
				update(modelo, null);
			}

		}

	}
}

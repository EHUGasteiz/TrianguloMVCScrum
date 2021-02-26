package es.ehu.eui.triangulo.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import es.ehu.eui.triangulo.model.TrianguloRectangulo;

import javax.swing.border.CompoundBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSpinner;
import javax.swing.JSlider;

import java.awt.SystemColor;

import javax.swing.UIManager;

public class VentanaTrianguloCompleta extends JFrame implements Observer {

	private static final long serialVersionUID = -2890366257923997969L;
	private JPanel contentPane;
	private JPanel pnlTexto;
	private JLabel lblBase;
	private JTextField txtBase;
	private JLabel lblAltura;
	private JLabel lblHipotenusa;
	private JTextField txtAltura;
	private JTextField txtHipotenusa;
	private PanelTrianguloGrafico pnlDibujo;
	private JPanel pnlOpcionesColor;
	private JRadioButton rdbtnRojo;
	private JRadioButton rdbtnAzul;
	private JRadioButton rdbtnNegro;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private TrianguloRectangulo modelo;
	private Color selectedColor;
	private Controlador controlador;
	private JPanel pnlGrosor;
	private JSlider sldGrosor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTrianguloCompleta frame = new VentanaTrianguloCompleta(
							new TrianguloRectangulo(10, 10));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaTrianguloCompleta(TrianguloRectangulo pTriangulo) {
		initialize();
		modelo = pTriangulo;
		modelo.addObserver(this);
		update(modelo, null);
	}

	private void initialize() {
		setTitle("Vista 4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(getPnlGrosor(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(getPnlOpcionesColor(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(getPnlTexto(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(getPnlDibujo(), GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(getPnlDibujo(), GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(getPnlTexto(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(getPnlOpcionesColor(), GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(getPnlGrosor(), GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private JPanel getPnlTexto() {
		if (pnlTexto == null) {
			pnlTexto = new JPanel();
			pnlTexto.setBorder(new TitledBorder(null,
					"Datos del tri\u00E1ngulo", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			GridBagLayout gbl_pnlTexto = new GridBagLayout();
			gbl_pnlTexto.columnWidths = new int[] { 0, 0, 0 };
			gbl_pnlTexto.rowHeights = new int[] { 0, 0, 0, 0 };
			gbl_pnlTexto.columnWeights = new double[] { 1.0, 1.0,
					Double.MIN_VALUE };
			gbl_pnlTexto.rowWeights = new double[] { 0.0, 0.0, 1.0,
					Double.MIN_VALUE };
			pnlTexto.setLayout(gbl_pnlTexto);
			GridBagConstraints gbc_lblBase = new GridBagConstraints();
			gbc_lblBase.insets = new Insets(0, 0, 5, 5);
			gbc_lblBase.anchor = GridBagConstraints.BELOW_BASELINE_LEADING;
			gbc_lblBase.gridx = 0;
			gbc_lblBase.gridy = 0;
			pnlTexto.add(getLblBase(), gbc_lblBase);
			GridBagConstraints gbc_txtBase = new GridBagConstraints();
			gbc_txtBase.insets = new Insets(0, 0, 5, 0);
			gbc_txtBase.gridx = 1;
			gbc_txtBase.gridy = 0;
			pnlTexto.add(getTxtBase(), gbc_txtBase);
			GridBagConstraints gbc_lblAltura = new GridBagConstraints();
			gbc_lblAltura.anchor = GridBagConstraints.WEST;
			gbc_lblAltura.insets = new Insets(0, 0, 5, 5);
			gbc_lblAltura.gridx = 0;
			gbc_lblAltura.gridy = 1;
			pnlTexto.add(getLblAltura(), gbc_lblAltura);
			GridBagConstraints gbc_txtAltura = new GridBagConstraints();
			gbc_txtAltura.insets = new Insets(0, 0, 5, 0);
			gbc_txtAltura.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAltura.gridx = 1;
			gbc_txtAltura.gridy = 1;
			pnlTexto.add(getTxtAltura(), gbc_txtAltura);
			GridBagConstraints gbc_lblHipotenusa = new GridBagConstraints();
			gbc_lblHipotenusa.anchor = GridBagConstraints.EAST;
			gbc_lblHipotenusa.fill = GridBagConstraints.VERTICAL;
			gbc_lblHipotenusa.insets = new Insets(0, 0, 0, 5);
			gbc_lblHipotenusa.gridx = 0;
			gbc_lblHipotenusa.gridy = 2;
			pnlTexto.add(getLblHipotenusa(), gbc_lblHipotenusa);
			GridBagConstraints gbc_txtHipotenusa = new GridBagConstraints();
			gbc_txtHipotenusa.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHipotenusa.gridx = 1;
			gbc_txtHipotenusa.gridy = 2;
			pnlTexto.add(getTxtHipotenusa(), gbc_txtHipotenusa);
		}
		return pnlTexto;
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

	private JLabel getLblHipotenusa() {
		if (lblHipotenusa == null) {
			lblHipotenusa = new JLabel("Hipotenusa:");
			lblHipotenusa.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		}
		return lblHipotenusa;
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

	private JTextField getTxtHipotenusa() {
		if (txtHipotenusa == null) {
			txtHipotenusa = new JTextField();
			txtHipotenusa.setEditable(false);
			txtHipotenusa.setColumns(10);
		}
		return txtHipotenusa;
	}

	private PanelTrianguloGrafico getPnlDibujo() {
		if (pnlDibujo == null) {
			pnlDibujo = new PanelTrianguloGrafico();
			pnlDibujo.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
			pnlDibujo.setBorder(new LineBorder(Color.BLACK, 2));
		}
		return pnlDibujo;
	}

	private JPanel getPnlOpcionesColor() {
		if (pnlOpcionesColor == null) {
			pnlOpcionesColor = new JPanel();
			pnlOpcionesColor.setBorder(new TitledBorder(new EtchedBorder(
					EtchedBorder.LOWERED, null, null), "Opciones color",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0,
							0, 0)));
			pnlOpcionesColor.setLayout(new GridLayout(3, 0, 0, 0));
			pnlOpcionesColor.add(getRdbtnNegro());
			pnlOpcionesColor.add(getRdbtnAzul());
			pnlOpcionesColor.add(getRdbtnRojo());
		}
		return pnlOpcionesColor;
	}

	private JRadioButton getRdbtnRojo() {
		if (rdbtnRojo == null) {
			rdbtnRojo = new JRadioButton("Rojo");
			buttonGroup.add(rdbtnRojo);
			rdbtnRojo.addActionListener(getControlador());
		}
		return rdbtnRojo;
	}

	private JRadioButton getRdbtnAzul() {
		if (rdbtnAzul == null) {
			rdbtnAzul = new JRadioButton("Azul");
			rdbtnAzul.addActionListener(getControlador());
			buttonGroup.add(rdbtnAzul);
		}
		return rdbtnAzul;
	}

	private JRadioButton getRdbtnNegro() {
		if (rdbtnNegro == null) {
			rdbtnNegro = new JRadioButton("Negro");
			rdbtnNegro.setSelected(true);
			buttonGroup.add(rdbtnNegro);
			rdbtnNegro.addActionListener(getControlador());
		}
		return rdbtnNegro;
	}

	public void update(Observable o, Object arg) {
		// Actualizar los cuadros de texto
		int base = modelo.getBase();
		int altura = modelo.getAltura();
		getTxtBase().setText(String.valueOf(base));
	    getTxtAltura().setText(String.valueOf(altura));
	    getTxtHipotenusa().setText(String.format("%1$.2f",modelo.getHipotenusa()));
		// redibujar el triangulo
	    getPnlDibujo().dibujarTriangulo(base, altura,selectedColor, getSldGrosor().getValue());
	}

	private Controlador getControlador() {
		if (controlador == null) {
			controlador = new Controlador();
		}
		return controlador;
	}

	private class Controlador implements ActionListener, ChangeListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof JTextField) {
				// Se han cambiado las dimensiones
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
			} else {
				// Se han cambiado las opciones
				if (getRdbtnNegro().isSelected()) {
					selectedColor = Color.BLACK;
				} else if (getRdbtnAzul().isSelected()) {
					selectedColor = Color.BLUE;
				} else {
					selectedColor = Color.RED;
				}
				update(modelo, null);
			}
		}

		public void stateChanged(ChangeEvent e) {
			update(modelo, null);
		}

	}
	private JPanel getPnlGrosor() {
		if (pnlGrosor == null) {
			pnlGrosor = new JPanel();
			pnlGrosor.setBorder(new TitledBorder(null, "Opciones grosor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlGrosor.add(getSldGrosor());
		}
		return pnlGrosor;
	}
	private JSlider getSldGrosor() {
		if (sldGrosor == null) {
			sldGrosor = new JSlider();
			sldGrosor.setValue(5);
			sldGrosor.setMinimum(1);
			sldGrosor.setMaximum(10);
			sldGrosor.addChangeListener(getControlador());
		}
		return sldGrosor;
	}
}

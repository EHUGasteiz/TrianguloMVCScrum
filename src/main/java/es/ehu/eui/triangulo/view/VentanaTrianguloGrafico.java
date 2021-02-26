package es.ehu.eui.triangulo.view;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.ehu.eui.triangulo.model.TrianguloRectangulo;

public class VentanaTrianguloGrafico extends JFrame implements Observer {

	private static final long serialVersionUID = -9184173532085395115L;
	private JPanel contentPane;
	private TrianguloRectangulo modelo;
	private PanelTrianguloGrafico pnlTrianguloGrafico;

	

	/**
	 * Creata una ventana
	 * 
	 * @param pTriangulo
	 *            - el triangulo que se refleja en la ventana
	 */
	public VentanaTrianguloGrafico(TrianguloRectangulo pTriangulo) {
		initialize();
		modelo = pTriangulo;
		// TODO: registrar la ventana como observadora del modelo
	}

	private void initialize() {
		setTitle("Vista 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 0, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnlTrianguloGrafico(), BorderLayout.CENTER);
	}

	public void update(Observable o, Object arg) {
		getPnlTrianguloGrafico().dibujarTriangulo(modelo.getBase(),modelo.getAltura());

	}

	private PanelTrianguloGrafico getPnlTrianguloGrafico() {
		if (pnlTrianguloGrafico == null) {
			pnlTrianguloGrafico = new PanelTrianguloGrafico();
			pnlTrianguloGrafico.setBorder(new EmptyBorder(5, 5, 5, 5));
		}
		return pnlTrianguloGrafico;
	}
}

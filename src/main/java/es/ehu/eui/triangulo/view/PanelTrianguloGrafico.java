package es.ehu.eui.triangulo.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.Window;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PanelTrianguloGrafico extends JPanel {
	private static final long serialVersionUID = 8313442043392839053L;
	private int base;
	private int altura;
	private final static int BASE_X = 30;
	// offset desde la izquierda para dibujar el triangulo (pixels)
	private final static int BASE_Y = 30;
	private Stroke stroke;

	// offset desde el borde superior para dibujar el triangulo (pixels)

	/**
	 * Crea un panel
	 */
	public PanelTrianguloGrafico() {

	}

	
	public void dibujarTriangulo(int pBase, int pAltura, Color pColor, int pStroke) {
		stroke = new BasicStroke(pStroke);
		dibujarTriangulo(pBase, pAltura, pColor);
	}
	
	public void dibujarTriangulo(int pBase, int pAltura, Color pColor) {
		setForeground(pColor);
		dibujarTriangulo(pBase, pAltura);
	}
	
	public void dibujarTriangulo(int pBase, int pAltura) {
		base = pBase;
		altura = pAltura;
		repaint();
		Container w = getTopLevelAncestor();
		if (w instanceof Window)
			((Window) w).pack();
	}

	/**
	 * Dibuja el triangulo en el panel
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint
          (RenderingHints.KEY_ANTIALIASING, 
            RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(stroke);
        g2.setColor(getForeground());
		g2.draw(new Line2D.Double(BASE_X, BASE_Y + altura, BASE_X + base, BASE_Y + altura));
		g2.draw(new Line2D.Double(BASE_X, BASE_Y, BASE_X, BASE_Y + altura));
		g2.draw(new Line2D.Double(BASE_X, BASE_Y, BASE_X + base, BASE_Y + altura)); 
	}

	/**
	 * Devuelve el tamaño preferido del panel
	 */
	public Dimension getPreferredSize() {
		return new Dimension(2 * BASE_X + base, 2 * BASE_Y + altura);
	}

	/**
	 * Devuelve el tamaño minimo del panel
	 */
	public Dimension getMinimumSize() {
		return getPreferredSize();
	}

}

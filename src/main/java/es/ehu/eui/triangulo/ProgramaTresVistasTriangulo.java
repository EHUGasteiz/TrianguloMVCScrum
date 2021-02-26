package es.ehu.eui.triangulo;

import es.ehu.eui.triangulo.model.TrianguloRectangulo;
import es.ehu.eui.triangulo.view.TRLogger;
import es.ehu.eui.triangulo.view.VentanaTrianguloGrafico;
import es.ehu.eui.triangulo.view.VentanaTrianguloTexto;

public class ProgramaTresVistasTriangulo {

	public static void main(String[] args) {
		TrianguloRectangulo tr = new TrianguloRectangulo(10,100);
		// TODO: Descomenta las lineas 
		// TRLogger trLogger = new TRLogger(tr);
		VentanaTrianguloTexto vTT = new  VentanaTrianguloTexto(tr);
		vTT.setVisible(true);
		// VentanaTrianguloGrafico vTG = new VentanaTrianguloGrafico(tr);
		// vTG.setVisible(true);
	}

}

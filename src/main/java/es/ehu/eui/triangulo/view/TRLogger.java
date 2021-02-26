package es.ehu.eui.triangulo.view;



import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import es.ehu.eui.triangulo.model.TrianguloRectangulo;

public class TRLogger implements PropertyChangeListener {
	private Logger logger;
	private TrianguloRectangulo modelo;
	
	public TRLogger(TrianguloRectangulo pTriangulo) {
		logger = Logger.getLogger(TRLogger.class);
		DOMConfigurator.configure(this.getClass().getResource("/logproperties.xml"));
		modelo = pTriangulo;
		modelo.addObserver(this);
		propertyChange(null);
	}


	public void propertyChange(PropertyChangeEvent evt) {
		// TODO: modificar el codigo para que refleje los cambios en el log 
		// String mensaje = String.format("Base: %.2f Altura: %.2f Hipotenusa: %.2f", 
		//		modelo.getBase(), modelo.getAltura(), modelo.getHipotenusa());
		// logger.info(mensaje)
	}

}

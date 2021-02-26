package es.ehu.eui.triangulo.model;

import static org.junit.Assert.*;
import static java.lang.Math.*;

import org.junit.Before;
import org.junit.Test;


public class TrianguloRectanguloTest {

	private TrianguloRectangulo tr1 = null;
	private TrianguloRectangulo tr2 = null;

	@Before
	public void setUp() throws Exception {
		tr1 = new TrianguloRectangulo(10, 100);
		tr2 = new TrianguloRectangulo(100, 90);
	}

	@Test
	public void testTrianguloRectangulo() {
		try {
			TrianguloRectangulo t1 = new TrianguloRectangulo(-1, 10);
			fail("Un triangulo no puede tener dimensiones negativas");
		} catch (IllegalArgumentException e) {

		}

		try {
			TrianguloRectangulo t1 = new TrianguloRectangulo(1, -10);
			fail("Un triangulo no puede tener dimensiones negativas");
		} catch (IllegalArgumentException e) {

		}
	}
	
	@Test
	public void testGetBase() {
		assertEquals("La base devuelta no es la adecuada",10, tr1.getBase());
		assertEquals("La base devuelta no es la adecuada",100, tr2.getBase());
	}
	
	@Test
	public void testGetAltura() {
		assertEquals("La altura devuelta no es la adecuada",100, tr1.getAltura());
		assertEquals("La altura devuelta no es la adecuada",90, tr2.getAltura());
	}
	
	@Test
	public void testHipotenusa() {
		assertEquals("La hipotenusa devuelta no es la adecuada",hip(tr1.getBase(),tr1.getAltura()), tr1.getHipotenusa(), 0.001);
		assertEquals("La hipotenusa devuelta no es la adecuada",hip(tr2.getBase(),tr2.getAltura()), tr2.getHipotenusa(), 0.001);
	}
	
	@Test
	public void setBase() {
		assertEquals(10, tr1.getBase());
		tr1.setBase(50);
		assertEquals("No se actualiza la base adecuadamente",50, tr1.getBase());
		assertEquals("No se actualiza adecuadamente la hipotenusa",hip(tr1.getBase(),tr1.getAltura()),tr1.getHipotenusa(), 0.001);
		
		try{
			tr2.setBase(-1);
			fail("No se controla adecuadamente que el valor para la base sea adecuado");
		}
		catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void setAltura() {
		assertEquals(100, tr1.getAltura());
		tr1.setAltura(50);
		assertEquals("No se actualiza la altura adecuadamente",50, tr1.getAltura());
		assertEquals("No se actualiza adecuadamente la hipotenusa",hip(tr1.getBase(),tr1.getAltura()),tr1.getHipotenusa(), 0.001);
		
		try{
			tr2.setAltura(-1);
			fail("No se controla adecuadamente que el valor para la base sea adecuado");
		}
		catch (IllegalArgumentException e) {
			
		}
	}
	
	private double hip(int pB, int pA) {
		return sqrt(pow(pB,2)+pow(pA,2));
	}

}

package mycompany.ListaDobEnlazada;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListaDoblementeEnlazadaTest {

	ListaDoblementeEnlazada l, l1, l2, l4;

	@Before
	public void crearListaVacia() {
		l = new ListaDoblementeEnlazada();
		l1 = new ListaDoblementeEnlazada();
		l1.insertarInicio(4);
		l2 = new ListaDoblementeEnlazada();
		l2.insertarInicio(4);
		l2.insertarInicio(3);
		l4 = new ListaDoblementeEnlazada();
		l4.insertarInicio(3);
		l4.insertarInicio(4);
		
	}

	@Test
	public void testListaDoblementeEnlazada() {
		ListaDoblementeEnlazada vacia = new ListaDoblementeEnlazada();
		assertEquals("Error al crear lista vacía", l.toString(), vacia.toString());
	}

	@Test
	public void testInsertarInicioEnListaVacia() {
		ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();
		lista.insertarInicio(4);
		assertEquals("Inserción al inicio errónea", l1.toString(), lista.toString());
	}
	
	@Test
	public void testInsertarInicioEnListaConUnElemento() {
		l1.insertarInicio(3);
		assertEquals("Inserción al inicio errónea", l1.toString(), l2.toString());
	}
	
	@Test
	public void testInsertarInicioEnListaConVariosElementos() {
		l2.insertarInicio(1);
		assertEquals("Inserción al inicio errónea", "1 -> 3 -> 4 -> null", l2.toString());
	}

	@Test
	public void testInsertarFinalEnListaVacia() {
		String lista1 = "4 -> null";
		ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();
		lista.insertarFinal(4);
		assertEquals("Inserción al final errónea", lista1, lista.toString());
	}
	
	@Test
	public void testInsertarFinalEnListaConUnElemento() {
		String lista1 = "4 -> 3 -> null";
		ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();
		lista.insertarFinal(4);
		lista.insertarFinal(3);
		assertEquals("Inserción al fial errónea", lista1, lista.toString());
	}
	
	@Test
	public void testInsertarFinalEnListaConVariosElementos() {
		String lista1 = "4 -> 3 -> 1 -> null";
		ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();
		lista.insertarFinal(4);
		lista.insertarFinal(3);
		lista.insertarFinal(1);
		assertEquals("Inserción al fial errónea", lista1, lista.toString());
	}

	@Test
	public void testEliminarInicioEnListaVacia() {
		String lista = "null";
		ListaDoblementeEnlazada lista1 = new ListaDoblementeEnlazada();
		lista1.eliminarInicio();
		assertEquals("Eliminación al inicio erronea", lista, lista1.toString());
	}
	
	@Test
	public void testEliminarInicioEnListaConUnElemento() {
		String lista = "null";
		ListaDoblementeEnlazada lista1 = new ListaDoblementeEnlazada();
		lista1.insertarInicio(4);
		lista1.eliminarInicio();
		assertEquals("Eliminación al inicio erronea", lista, lista1.toString());
	}
	
	@Test
	public void testEliminarInicioEnListaConVariosElementos() {
		String lista = "4 -> null";
		ListaDoblementeEnlazada lista1 = new ListaDoblementeEnlazada();
		lista1.insertarInicio(4);
		lista1.insertarInicio(3);
		lista1.eliminarInicio();
		assertEquals("Eliminación al inicio erronea", lista, lista1.toString());
	}


	@Test
	public void testEliminarFinalEnListaVacia() {
		String lista = "null";
		ListaDoblementeEnlazada lista1 = new ListaDoblementeEnlazada();
		lista1.eliminarFinal();
		assertEquals("Eliminación al final erronea", lista, lista1.toString());
	}
	
	@Test
	public void testEliminarFinalEnListaConUnElemento() {
		String lista = "null";
		ListaDoblementeEnlazada lista1 = new ListaDoblementeEnlazada();
		lista1.insertarFinal(4);
		lista1.eliminarFinal();
		assertEquals("Eliminación al final erronea", lista, lista1.toString());
	}
	
	@Test
	public void testEliminarFinalEnListaConVariosElementos() {
		String lista = "4 -> null";
		ListaDoblementeEnlazada lista1 = new ListaDoblementeEnlazada();
		lista1.insertarFinal(4);
		lista1.insertarFinal(3);
		lista1.eliminarFinal();
		assertEquals("Eliminación al final erronea", lista, lista1.toString());
	}


	@Test
	public void testBuscarEnListaVacia() {
		ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();
		assertNull("Búsqueda en lista vacía errónea", lista.buscar(4));
	}
	
	@Test
	public void testBuscarEnListaNoVaciaSinElElemento() {
		ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();
		lista.insertarFinal(3);
		assertNull("Búsqueda en lista no vacía errónea", lista.buscar(4));
	}
	
	@Test
	public void testBuscarEnListaNoVaciaConElElemento() {
		ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();
		lista.insertarFinal(4);
		assertEquals("Búsqueda en lista no vacía errónea", 4, lista.buscar(4).dato);
	}
	
	@Test
	public void testToStringListaVacia() {
		String lista = "null";
		ListaDoblementeEnlazada lista1 = new ListaDoblementeEnlazada();
		assertEquals("toString incorrecto", lista, lista1.toString());
	}
	
	@Test
	public void testToStringListaNoVacia() {
		String lista = "4 -> 3 -> null";
		assertEquals("toString incorrecto", lista, l4.toString());
	}
}

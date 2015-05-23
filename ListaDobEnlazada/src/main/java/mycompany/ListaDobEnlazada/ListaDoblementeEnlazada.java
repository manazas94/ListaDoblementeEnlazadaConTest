package mycompany.ListaDobEnlazada;
public class ListaDoblementeEnlazada {

	/*
	 * Nodo principal
	 */
	class Nodo {
		int dato;
		Nodo ant, sig;

		public Nodo(int dato) {
			this.dato = dato;
			ant = null;
			sig = null;
		}
	}

	// Referencias al primer y �ltimo nodo
	private Nodo principio, fin;

	// Constructor de una lista vac�a
	public ListaDoblementeEnlazada() {
		principio = null;
		fin = null;
	}

	/*
	 * M�todo auxiliar que usaremos para saber si una lista est� vac�a
	 */
	private boolean estaVacia() {
		boolean vacia = false;
		if (principio == null) {
			vacia = true;
		}
		return vacia;
	}

	/*
	 * M�todo auxiliar para enlazar dos nodos
	 */
	private void enlazar(Nodo nodo1, Nodo nodo2) {
		nodo1.sig = nodo2;
		nodo2.ant = nodo1;
	}

	/*
	 * Inserta un nuevo nodo al principio de la lista
	 */
	public void insertarInicio(int dato) {
		Nodo nuevo = new Nodo(dato);
		if (estaVacia()) {
			principio = nuevo;
			fin = nuevo;
		} else {
			enlazar(nuevo, principio);
			principio = nuevo;
		}
	}

	/*
	 * Insertar un nuevo nodo al final de la lista
	 */
	public void insertarFinal(int dato) {
		Nodo nuevo = new Nodo(dato);
		if (estaVacia()) {
			principio = nuevo;
			fin = nuevo;
		} else {
			enlazar(fin, nuevo);
			fin = nuevo;
		}
	}

	/*
	 * Eliminaci�n del primer nodo
	 */
	public void eliminarInicio() {
		if (!estaVacia()) {
			Nodo segundo = principio.sig;
			if (segundo == null) {
				principio = null;
				fin = null;
			} else {
				segundo.ant = null;
				principio = segundo;
			}
		}
	}

	/*
	 * Eliminaci�n del �ltimo nodo
	 */
	public void eliminarFinal() {
		if (!estaVacia()) {
			Nodo ultimo = fin.ant;
			if (ultimo == null) {
				principio = null;
				fin = null;
			} else {
				ultimo.sig = null;
				fin = ultimo;
			}
		}
	}

	/*
	 * Referencia al nodo buscado
	 */
	public Nodo buscar(int dato) {
		Nodo buscado = null;
		Nodo iter = principio;
		while (buscado == null && iter != null) {
			if (iter.dato == dato) {
				buscado = iter;
			}
			iter = iter.sig;
		}
		return buscado;
	}

	/*
	 * M�todo para mostrar los datos de la lista
	 */
	public void mostrar() {
		Nodo iter = principio;
		while (iter != null) {
			System.out.print(iter.dato + " -> ");
			iter = iter.sig;
		}
		System.out.println("null");
	}
	
	public String toString() {
		String lista = "";
		
		Nodo iter = principio;
		while (iter != null) {
			lista += (iter.dato + " -> ");
			iter = iter.sig;
		}
		lista+="null";
		
		return lista;
	}
	
	/*
	 * Main para testear la lista
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();
		lista.insertarInicio(2);
		lista.insertarInicio(4);
		lista.insertarFinal(5);
		lista.insertarInicio(1);
		lista.insertarFinal(5);
		lista.insertarFinal(6);
		lista.insertarInicio(7);
		lista.insertarInicio(10);
		lista.insertarInicio(12);
		lista.insertarInicio(4);
		lista.insertarFinal(8);
		lista.mostrar();
		Nodo a = lista.buscar(9);
		System.out.println((a != null) ? "elemento encontrado en la lista" : "elemento no encontrado en la lista");
		Nodo b = lista.buscar(1);
		System.out.println((b != null) ? "elemento encontrado en la lista" : "elemento no encontrado en la lista");
		lista.eliminarFinal();
		lista.eliminarInicio();
		lista.eliminarFinal();
		lista.eliminarFinal();
		lista.eliminarFinal();
		lista.eliminarFinal();
		lista.eliminarInicio();
		lista.eliminarInicio();
		lista.eliminarFinal();
		lista.eliminarFinal();
		lista.eliminarFinal();
		lista.mostrar();
	}

}
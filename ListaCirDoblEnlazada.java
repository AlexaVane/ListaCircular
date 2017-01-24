
public class ListaCirDoblEnlazada {

	// Puntero que indica el inicio de la lista o conocida tambien
	// como cabeza de la lista.
	NodoCircular inicio;
	NodoCircular ultimo;

	// Variable para registrar el tama�o de la lista.
	public int tamanio;


	public void Lista(){
		inicio = null;
		ultimo= null;
		tamanio = 0;
	}

	public boolean esVacia(){
		if(inicio==null){
			System.out.println("sipi");
			return true;
			}
		
		else 
			System.out.println("nop");
			return false;
	}

	public int getTamanio(){
		 int cant = 0;
	        if (!esVacia()) {
	            NodoCircular reco=inicio;
	            do {
	                cant++;
	                reco = reco.siguiente;                
	            } while (reco!=inicio);
	        }  
		return tamanio;
	}

	public void agregarAlFinal(int valor){
		// Define un nuevo nodo.
		NodoCircular nuevo = new NodoCircular(valor);
	/*	// Agrega al valor al nodo.
	
		// Consulta si la lista esta vacia.
		if (esVacia()) {
			// Inicializa la lista agregando como inicio al nuevo nodo.
			ultimo = nuevo;
			inicio.siguiente= inicio;
			nuevo.anterior = inicio;
			ultimo= nuevo;

		} else{
			ultimo.siguiente = nuevo;
        	nuevo.siguiente = inicio;
        	nuevo.anterior = ultimo;
        	ultimo = nuevo;
        	inicio.anterior =ultimo ;
        	System.out.println("gggg");
			
			// Apuntamos con el ultimo nodo de la lista al nuevo.
			//inicio.setSiguiente(nuevo);
			// Apuntamos con el nuevo nodo al inicio de la lista.
			//nuevo.setSiguiente(inicio);
			// Como ahora como el nuevo nodo es el ultimo se actualiza
			// la variable ultimo.
			//inicio = nuevo;
		//}
		// Incrementa el contador de tama�o de la lista
		 * 
	
*/		
		 if(inicio==null)
             inicio=nuevo;
   else{
             NodoCircular aux=inicio;
             while(aux.getSiguiente()!=inicio)
                      aux=aux.getSiguiente();
             aux.setSiguiente(nuevo);
             nuevo.setAnterior(aux);
             nuevo.setSiguiente(inicio);
             inicio.setAnterior(nuevo);
   }
		 tamanio ++;
 }
		
		
	

	public void agregarAlInicio(int valor){
		// Define un nuevo nodo.
		NodoCircular nuevo = new NodoCircular(valor);
		// Agrega al valor al nodo.

		// Consulta si la lista esta vacia.
		if(inicio==null)
            inicio=nuevo;
  else{
            NodoCircular aux=inicio;
            while(aux.getSiguiente()!=inicio)//null no esta definido 
                     aux=aux.getSiguiente();
            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux);
            nuevo.setSiguiente(inicio);
            inicio.setAnterior(nuevo);
            inicio=nuevo;
           
  }
		// Incrementa el contador de tama�o de la lista.
		tamanio++;
	}

	public void insertarPorReferencia(int referencia, int valor){
		// Define un nuevo nodo.
		NodoCircular nuevo = new NodoCircular(valor);
		// Agrega al valor al nodo.
		nuevo.setValor(valor);
		// Verifica si la lista contiene elementos
		if (!esVacia()) {
			// Consulta si el valor existe en la lista.
			if (buscar(referencia)) {
				// Crea ua copia de la lista.
				NodoCircular aux = inicio;
				// Recorre la lista hasta llegar al nodo de referencia.
				while (aux.getValor() != referencia) {
					aux = aux.getSiguiente();
				}
				// Consulta si el nodo a insertar va despues del ultimo
				if (aux == ultimo) {
					// Apuntamos con el ultimo nodo de la lista al nuevo.
					aux.setSiguiente(nuevo);
					// Apuntamos con el nuevo nodo al inicio de la lista.
					nuevo.setSiguiente(inicio);
					// Como ahora como el nuevo nodo es el ultimo se actualiza
					// la variable ultimo.
					ultimo = nuevo;
				} else {
					// Crea un respaldo de la continuaci�n de la lista.
					NodoCircular siguiente = aux.getSiguiente();
					// Enlaza el nuevo nodo despues del nodo de referencia.
					aux.setSiguiente(nuevo);
					// Une la continuacion de la lista al nuevo nodo.
					nuevo.setSiguiente(siguiente);
				}
				// Incrementa el contador de tama�o de la lista.
				tamanio++;
			}
		}      
	}

	public void insrtarPorPosicion(int posicion, int valor){
		// Verifica si la posici�n ingresada se encuentre en el rango
		// >= 0 y <= que el numero de elementos del la lista.
		if(posicion>=0 && posicion<=tamanio){
			NodoCircular nuevo = new NodoCircular(valor);
			//  nuevo.setValor(valor);
			// Consulta si el nuevo nodo a ingresar va al inicio de la lista.
			if(posicion == 0){
				// Une el nuevo nodo con la lista existente.
				nuevo.setSiguiente(inicio);
				// Renombra al nuevo nodo como el inicio de la lista.
				inicio = nuevo;
				// El puntero del ultimo debe apuntar al primero.
				ultimo.setSiguiente(inicio);
			}
			else{
				// Si el nodo a inserta va al final de la lista.
				if(posicion == tamanio){
					// Apuntamos con el ultimo nodo de la lista al nuevo.
					ultimo.setSiguiente(nuevo);
					// Apuntamos con el nuevo nodo al inicio de la lista.
					nuevo.setSiguiente(inicio);
					// Como ahora como el nuevo nodo es el ultimo se actualiza
					// la variable ultimo.
					ultimo = nuevo;     
				}
				else{
					// Si el nodo a insertar va en el medio de la lista.
					NodoCircular aux = inicio;
					// Recorre la lista hasta llegar al nodo anterior
					// a la posicion en la cual se insertara el nuevo nodo.
					for (int i = 0; i < (posicion-1); i++) {
						aux = aux.getSiguiente();
					}
					// Guarda el nodo siguiente al nodo en la posici�n
					// en la cual va a insertar el nevo nodo.
					NodoCircular siguiente = aux.getSiguiente();
					// Inserta el nuevo nodo en la posici�n indicada.
					aux.setSiguiente(nuevo);
					// Une el nuevo nodo con el resto de la lista.
					nuevo.setSiguiente(siguiente);
				}
			}
			// Incrementa el contador de tama�o de la lista.
			tamanio++;
		}
	}

	public int getValor(int posicion) {
		
		/* NodoCircular aux=inicio;
         while((aux.getSiguiente()!=inicio) && (!(aux.getValor() == posicion)))
                   aux=aux.getSiguiente();
         if(aux.getValor() == posicion)
         return true;
         
         else {
        	 return false;
         }
			}*/
		
		   if(posicion>=0 && posicion<tamanio){      
	            if (posicion == 0) {
	              
	                return inicio.valor;
	            }else{
	             
	            	NodoCircular aux = inicio;
	              
	                for (int i = 0; i < posicion; i++) {
	                    aux = aux.getSiguiente();
	                }
	                return aux.getValor(); 
	            }
	}
		   return posicion;
	}
	
	public boolean buscar(int referencia){
		// Crea una copia de la lista.
		NodoCircular aux = inicio;
		// Bandera para indicar si el valor existe.
		boolean encontrado = false;
		// Recorre la lista hasta encontrar el elemento o hasta 
		// llegar al primer nodo nuevamente.
		do{
			// Consulta si el valor del nodo es igual al de referencia.
			if (referencia == aux.getValor()){
				// Canbia el valor de la bandera.
				encontrado = true;
			}
			else{
				// Avansa al siguiente. nodo.
				aux = aux.getSiguiente();
			}
		}while(aux != inicio && encontrado != true);
		// Retorna el resultado de la bandera.
		return encontrado;
	}

	public int getPosicion(int referencia) throws Exception{
		// Consulta si el valor existe en la lista.
		if (buscar(referencia)) {
			// Crea una copia de la lista.
			NodoCircular aux = inicio;
			// COntado para almacenar la posici�n del nodo.
			int cont = 0;
			// Recoore la lista hasta llegar al nodo de referencia.
			while(referencia != aux.getValor()){
				// Incrementa el contador.
				cont ++;
				// Avansa al siguiente. nodo.
				aux = aux.getSiguiente();
			}
			// Retorna el valor del contador.
			return cont;
			// Crea una excepci�n de Valor inexistente en la lista.
		} else {
			throw new Exception("Valor inexistente en la lista.");
		}
	}

	public void editarPorReferencia(int referencia, int valor){
		// Consulta si el valor existe en la lista.
		if (buscar(referencia)) {
			// Crea ua copia de la lista.
			NodoCircular aux = inicio;
			// Recorre la lista hasta llegar al nodo de referencia.
			while(aux.getValor() != referencia){
				aux = aux.getSiguiente();
			}
			// Actualizamos el valor del nodo
			aux.setValor(valor);
		}
	}

	public void editarPorPosicion(int posicion , int valor){
		// Verifica si la posici�n ingresada se encuentre en el rango
		// >= 0 y < que el numero de elementos del la lista.
		if(posicion>=0 && posicion<tamanio){
			// Consulta si el nodo a eliminar es el primero.
			if(posicion == 0){
				// Alctualiza el valor delprimer nodo.
				inicio.setValor(valor);
			}
			else{
				// En caso que el nodo a eliminar este por el medio 
				// o sea el ultimo
				NodoCircular aux = inicio;
				// Recorre la lista hasta lleger al nodo anterior al eliminar.
				for (int i = 0; i < posicion; i++) {
					aux = aux.getSiguiente();
				}
				// Alctualiza el valor del nodo.
				aux.setValor(valor);
			}
		}
	}

	public void removerPorReferencia(int referencia){
		// Consulta si el valor de referencia existe en la lista.
		if (buscar(referencia)) {
			// Consulta si el nodo a eliminar es el pirmero
			if (inicio.getValor() == referencia) {
				// El primer nodo apunta al siguiente.
				inicio = inicio.getSiguiente();
				// Apuntamos con el ultimo nodo de la lista al inicio.
				ultimo.setSiguiente(inicio); 
			} else{
				// Crea ua copia de la lista.
				NodoCircular aux = inicio;
				// Recorre la lista hasta llegar al nodo anterior 
				// al de referencia.
				while(aux.getSiguiente().getValor() != referencia){
					aux = aux.getSiguiente();
				}
				if (aux.getSiguiente() == ultimo) {
					aux.setSiguiente(inicio);
					ultimo = aux;
				} else {
					// Guarda el nodo siguiente del nodo a eliminar.
					NodoCircular siguiente = aux.getSiguiente();
					// Enlaza el nodo anterior al de eliminar con el 
					// sguiente despues de el.
					aux.setSiguiente(siguiente.getSiguiente());  
					// Actualizamos el puntero del ultimo nodo
				}
			}
			// Disminuye el contador de tama�o de la lista.
			tamanio--;
		}
	}

	public void removerPorPosicion(int posicion){
		// Verifica si la posici�n ingresada se encuentre en el rango
		// >= 0 y < que el numero de elementos del la lista.
		if(posicion>=0 && posicion<tamanio){
			// Consulta si el nodo a eliminar es el primero
			if(posicion == 0){
				// Elimina el primer nodo apuntando al siguinte.
				inicio = inicio.getSiguiente();
				// Apuntamos con el ultimo nodo de la lista al inicio.
				ultimo.setSiguiente(inicio);
			}
			// En caso que el nodo a eliminar este por el medio 
			// o sea el ultimo
			else{
				// Crea una copia de la lista.
				NodoCircular aux = inicio;
				// Recorre la lista hasta lleger al nodo anterior al eliminar.
				for (int i = 0; i < posicion-1; i++) {
					aux = aux.getSiguiente();
				}
				if (aux.getSiguiente() == ultimo) {
					aux.setSiguiente(inicio);
					ultimo = aux;
				} else {
					// Guarda el nodo siguiente del nodo a eliminar.
					NodoCircular siguiente = aux.getSiguiente();
					// Enlaza el nodo anterior al de eliminar con el 
					// sguiente despues de el.
					aux.setSiguiente(siguiente.getSiguiente());  
					// Actualizamos el puntero del ultimo nodo
				}
			}
			// Disminuye el contador de tama�o de la lista.
			tamanio--;
		}
	}

	public void eliminar(){
		// Elimina el valor y la referencia a los demas nodos.
		inicio = null;
		// Elimina el valor y la referencia al primer nodo.
		ultimo = null;
		// Reinicia el contador de tama�o de la lista a 0.
		tamanio = 0;
	}  

	public void listar(){
		// Verifica si la lista contiene elementoa.
		// if (!esVacia()) {
		// Crea una copia de la lista.
		NodoCircular aux = inicio;
		// Posicion de los elementos de la lista.
		int i = 0;
		System.out.print("-> ");
		// Recorre la lista hasta llegar nuevamente al incio de la lista.
		do{
			// Imprime en pantalla el valor del nodo.
			System.out.print(i + ".[ " + aux.valor + " ]" + " ->  ");
			// Avanza al siguiente nodo.
			aux = aux.siguiente;
			// Incrementa el contador de la posi�n.
			i++;
		}while(aux != inicio);
		//  }
	}
}
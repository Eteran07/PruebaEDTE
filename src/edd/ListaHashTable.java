/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author Edgar 
 * 
 * //Lista enlazada para el manejo de colisiones en la tabla de hash table
 */

//En cada Instancia corresponde a un indice en la tabla hash almacenado nodos en otra clase auxiliar de tipo NodoListaHashTable
public class ListaHashTable {
    public NodoListaHashTable head; //cabeza de la lista enlazada
    public String indice; //indice asociado a esta lista
    public int size; //Tamaño de la lista

    public ListaHashTable () {
        head = null;
        indice = ""; 
        size = 0;
    }
    
     
    //permite inicializar la lista con un indice en especifico
    
    public ListaHashTable (boolean nueva_sucursal,String new_indice) {
        head = null;
        indice = new_indice;

    }
    
    public NodoListaHashTable crearNodo(String value, NodoLista nodoarbol) {
        NodoListaHashTable nodo = new NodoListaHashTable(value,nodoarbol,null); //crea un nuevo nodo de tipo NodoListaHasht
        return nodo; //retorna el nodo creado
    }
    
    
    //FUNCION QUE PERMITE INSERTAR Y ASOCIAR UN NUEVO NODO EN LA LISTA
    
    public NodoListaHashTable insertar(NodoLista nodoarbol ) {
        NodoListaHashTable nodo = crearNodo((String)nodoarbol.getNombre(),nodoarbol);
        if (head==null) {
            head = nodo; //Si la lista esta vacia el nuevo nodo se convierte en la cabeza
        } 
        
        else {
            NodoListaHashTable pointer = head; // si no el puntero se inicializa en la cabeza
            while(pointer.next != null) { //Condicional que recorre la lista hasta el final e inserta un nodo al final de la misma
                pointer = pointer.next;
            }
            pointer.next=nodo;
        }
        size ++;
        return nodo;

    }
    
    public NodoListaHashTable eliminar(String val) { //funcion que elimina el nodo en la lista enlazada
        if (head == null) return null;

        NodoListaHashTable deleteNode = head;
        
        if (deleteNode.val == val) {
            head = head.next;
            deleteNode = null;
            return head;
        }

        while (deleteNode.next!=null && deleteNode.next.val != val){
            deleteNode = deleteNode.next;
        }
            
        
        if (deleteNode.next==null)return head;
        
        NodoListaHashTable aux = deleteNode.next;
        deleteNode.next = aux.next;
        size --;
        return head;
    }
    
    public boolean busqueda(String val) { //genera la busqueda desde el hashS
        NodoListaHashTable aux = head;

        while (aux != null){

            if (aux.val.equals(val)) {
                System.out.println("SE ENCONTRO EL VALOR " +val + " EN LA LISTA" );
                return true;
            }
            aux = aux.next;
        }

        System.out.println("No SE ENCONTRO EL VALOR " +val + " EN LA LISTA" );
        return false;
    }
    
    public boolean buscar(String mote){
        /*
        Metodo de busqueda por Mote para ver si existe el elemento en la lista
        */
        NodoListaHashTable aux = head;
            
        while (aux != null){

            if (aux.nodoarbol.getMote().equals(mote)) {
                return true;
            }
            aux = aux.next;
        }


        return false;
    }
}



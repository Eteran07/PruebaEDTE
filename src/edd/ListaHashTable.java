/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author Edgar 
 */
public class ListaHashTable {
    public NodoListaHashTable head;
    public String indice;
    public int size;

    public ListaHashTable () {
        head = null;
        indice = "";
        size = 0;
    }
    
     
    public ListaHashTable (boolean nueva_sucursal,String new_indice) {
        head = null;
        indice = new_indice;

    }
    
    public NodoListaHashTable crearNodo(String value, NodoLista nodoarbol) {
        NodoListaHashTable nodo = new NodoListaHashTable(value,nodoarbol,null);
        return nodo;
    }
    
    public NodoListaHashTable insertar(NodoLista nodoarbol ) {
        NodoListaHashTable nodo = crearNodo((String)nodoarbol.getNombre(),nodoarbol);
        if (head==null) {
            head = nodo;
        } 
        
        else {
            NodoListaHashTable pointer = head;
            while(pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next=nodo;
        }
        size ++;
        return nodo;

    }
    
    public NodoListaHashTable eliminar(String val) {
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



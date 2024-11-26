/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author Edgar
 */
//permite el manejo de colisiones 
// cada nodo almacena un enlace al siguiente nodo de tipo NodoLista
public class NodoListaHashTable {
    public String val;
    public NodoListaHashTable next;
    public NodoLista nodoarbol; //Nodo asociado formato nodolista 
    
    public NodoListaHashTable (String val_new, NodoLista nodoarbol_new, NodoListaHashTable siguiente) {
        val = val_new; // asigna el valor al nodo
        next = siguiente; // Punto de referencia para el siguiente nodo
        nodoarbol = nodoarbol_new; //Inicializa el nodo al tipo Nodo Lista
    }
}

 
 
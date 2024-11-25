/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author Edgar
 */
public class NodoListaHashTable {
    public String val;
    public NodoListaHashTable next;
    public NodoLista nodoarbol;
    public NodoListaHashTable (String val_new, NodoLista nodoarbol_new, NodoListaHashTable siguiente) {
        val = val_new;
        next = siguiente;
        nodoarbol = nodoarbol_new;
    }
}

 
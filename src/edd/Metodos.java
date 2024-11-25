/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author Alejandro
 */
public class Metodos {

    private HashTable Hast;
    private HashTable nombre;

    public Metodos(HashTable hash) {
        this.Hast = hash;
    }

    public String verRegistro(String mote) {
        NodoLista nodo = this.Hast.gettNodeById(mote);
        return nodo.toString();

    }

    public NodoLista[] buscarPorNombre(String nombre) {
        /*
        Metodo de buscar todo los registros por nombres, para usar en la interfaz(comboBox)
         */
        ListaHashTable lista = this.nombre.getPersonajePorNombre(nombre); // Se busca por nombre y se alamcena en la lista
        NodoLista nodo = this.Hast.gettNodeById(nombre); //Se busca por Mote y se almacena por mote 
        if (lista.size != 0) {
            NodoListaHashTable aux = lista.head;
            NodoLista[] personajes = new NodoLista[lista.size + 1];
            int index = 0;
            while (aux != null) {
                personajes[index] = aux.nodoarbol; //Isercion de los Todos los nodos que coinciden en al arreglo 
                aux = aux.next;
                index++;
            }

            if (nodo != null) {
                personajes[lista.size] = nodo;
            }
            return personajes;

        } else if (nodo != null) {
            NodoLista[] personajes = new NodoLista[1];
            personajes[0] = nodo;
            return personajes;

        }
        return null;
    }

    public NodoLista[] busquedaPorTitulo(String titulo) {
        ListaHashTable lista = this.nombre.getPersonajePorTitulo(titulo); // Se busca por nombre y se alamcena en la lista
        if (lista.size != 0) {
            NodoListaHashTable aux = lista.head;
            NodoLista[] personajes = new NodoLista[lista.size];
            int index = 0;
            while (aux != null) {
                personajes[index] = aux.nodoarbol; //Isercion de los Todos los nodos que coinciden en al arreglo 
                aux = aux.next;
                index++;
            }
            return personajes;
        }
        return null;
    }
}
// Test para problema de libreria
// Validaciones, revisar el metodo 6 y interfaz completar y cargado de archivos y lo del grahpstream.

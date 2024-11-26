/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author Edgar
 */

//permite la visualizacion del arbol usando GraphStream

public class MostrarArboles {

    public Graph graph; //Grafo

    public MostrarArboles() {
        graph = new SingleGraph("Red de Transporte");
        //graph.setAttribute("ui.stylesheet", "node{fill-color: green} edge{fill-color: black}");     
    }

    public void AgregarParada(String parada) {

        graph.addNode(parada); // Agrega un nodo al grafo con el nombre especifico
        graph.getNode(parada).setAttribute("ui.label", parada); //se establece la etiqueta
//       graph.getNode(parada).setAttribute("ui.style",
//        "fill-color: blue;size: 40px;text-size: 16px;font: bold 16px arial;text-alignment: center;");

        // Color de relleno a
    }

    public void AgregarConexion(String parada1, String parada2) {
        //graph.addEdge(parada1 +"-"+ parada2, parada1, parada2, true);
        graph.addEdge(parada1 + parada2, parada1, parada2, false); //permite agregar una arista
        
    }

    public void mostrar(Tree arbol) { //parametro arbol es lo que se desea mostrar
        
        CreacionNodos(arbol.getRoot()); //crea los nodos a partir de un arbol obteniendo su raiz como referencia
        CreacionConexiones(arbol.getRoot()); // se crean las conexiones a partir del arbol obteniendo su raiz como referencia
        graph.display(); //muestra el grafo

    }

    public void CreacionNodos(NodoLista nodo) {
        if(graph.getNode(nodo.getMote()) == null){
        AgregarParada(nodo.getMote()); //agrega el nodo al grafo si esta es nula
        }
        // AgregarParada(nodo.getMote());

        
        for (NodoLista son : nodo.getSons()) {
            CreacionNodos(son);
        }
    }

    //creacion de conexiones usando el nodo actual del arbol
    
    public void CreacionConexiones(NodoLista Nodo) {
        if (Nodo == null){
            return;
        }
        for (NodoLista son : Nodo.getSons()) {
            AgregarConexion(Nodo.getMote(), son.getMote());
            CreacionConexiones(son);
            
        }
    }

    //Permite mostrar los Ancestros 
    public void mostrarAncestros(NodoLista nodo) {
        if (nodo == null) {
            return;
        }
        
        
        
        if(graph.getNode(nodo.getMote()) == null){
        AgregarParada(nodo.getMote()); 
        }
       mostrarAncestros(nodo.getParent()); //realiza la llamada recursiva para la madre y el padre hasta que lo encuentre 
        mostrarAncestros(nodo.getMother());
    }
    
    //Permite crear las conexiones entre ancestros y mostrarlos
    
    public void mostrarAncestrosConexiones(NodoLista nodo) {
        if (nodo == null) {
            return;
        }
        
        //Si existe el padre crea la conexiòn
        
        if (nodo.getParent()!= null){
       AgregarConexion(nodo.getMote(), nodo.getParent().getMote());
        }
        
        
        //si existe la madre crea la conexion
       if (nodo.getMother()!= null) {
           AgregarConexion(nodo.getMote(),nodo.getMother().getMote());
       }
        mostrarAncestrosConexiones(nodo.getParent()); //realiza la llamada recursiva al padre 
       mostrarAncestrosConexiones(nodo.getMother()); //realiza la llamada recursiva a la madre
       
       
    }
    

    public void mostrarVisualAncestros(NodoLista nodo) {
        mostrarAncestros(nodo); //llamada a la funcion para ser agregados al grafo
        mostrarAncestrosConexiones (nodo); // Permite crear las conexiones entre los ancestros del grafo
        graph.display();

    }

}

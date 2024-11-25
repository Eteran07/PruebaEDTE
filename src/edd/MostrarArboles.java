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
public class MostrarArboles {

    public Graph graph;

    public MostrarArboles() {
        graph = new SingleGraph("Red de Transporte");
        //graph.setAttribute("ui.stylesheet", "node{fill-color: green} edge{fill-color: black}");     
    }

    public void AgregarParada(String parada) {

        graph.addNode(parada);
        graph.getNode(parada).setAttribute("ui.label", parada);
//       graph.getNode(parada).setAttribute("ui.style",
//        "fill-color: blue;size: 40px;text-size: 16px;font: bold 16px arial;text-alignment: center;");

        // Color de relleno
    }

    public void AgregarConexion(String parada1, String parada2) {
        //graph.addEdge(parada1 +"-"+ parada2, parada1, parada2, true);
        graph.addEdge(parada1 + parada2, parada1, parada2, false);
        
    }

    public void mostrar(Tree arbol) {
        CreacionNodos(arbol.getRoot());
        CreacionConexiones(arbol.getRoot());
        graph.display();

    }

    public void CreacionNodos(NodoLista nodo) {
        if(graph.getNode(nodo.getMote()) == null){
        AgregarParada(nodo.getMote());
        }
        // AgregarParada(nodo.getMote());

        for (NodoLista son : nodo.getSons()) {
            CreacionNodos(son);
        }
    }

    public void CreacionConexiones(NodoLista Nodo) {
        if (Nodo == null){
            return;
        }
        for (NodoLista son : Nodo.getSons()) {
            AgregarConexion(Nodo.getMote(), son.getMote());
            CreacionConexiones(son);
            
        }
    }

    public void mostrarAncestros(NodoLista nodo) {
        if (nodo == null) {
            return;
        }
        
        
        
        if(graph.getNode(nodo.getMote()) == null){
        AgregarParada(nodo.getMote());
        }
       mostrarAncestros(nodo.getParent());
        mostrarAncestros(nodo.getMother());
    }
    
    public void mostrarAncestrosConexiones(NodoLista nodo) {
        if (nodo == null) {
            return;
        }
        if (nodo.getParent()!= null){
       AgregarConexion(nodo.getMote(), nodo.getParent().getMote());
        }
        
       if (nodo.getMother()!= null) {
           AgregarConexion(nodo.getMote(),nodo.getMother().getMote());
       }
        mostrarAncestrosConexiones(nodo.getParent());
       mostrarAncestrosConexiones(nodo.getMother());
       
       
    }
    

    public void mostrarVisualAncestros(NodoLista nodo) {
        mostrarAncestros(nodo);
        mostrarAncestrosConexiones (nodo);
        graph.display();

    }

}

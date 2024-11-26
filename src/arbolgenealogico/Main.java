/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolgenealogico;

import edd.NodoLista;
import edd.Tree;
import edd.NodoListaHashTable;
import edd.ListaHashTable;
import edd.MostrarArboles;
/**
 *
 * @author Alejandro
 */
public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Interfaz().setVisible(true);
        });
    
        
        Tree tree = new Tree();
        NodoLista nodoarbol;
        
        tree.insert("Jhon Snow", -1, -1, null,"Jhon Snow", "Casa", "Verdes", "Marron", "lo que sea", "Estudiando fisica");//0
        tree.insert("Carlos", 0, -1,tree.getRoot(),"Carlos","Casa", "Verdes", "Marron", "lo que sea", "Estudiando fisica");
        tree.insert("Juan", 0,  -1,tree.getRoot(),"Juan", "Casa", "Verdes", "Marron", "lo que sea", "Estudiando fisica");//2
        tree.insert("Maria", 0,  -1,tree.getRoot(),"Maria", "Casa", "Verdes", "Marron", "lo que sea", "Estudiando fisica");//3
        tree.insert("Fernando", 0, -1, tree.getRoot(),"Fernando", "Casa", "Verdes", "Marron", "lo que sea", "Estudiando fisica");
        tree.insert("Marcos", 1,  3 ,tree.getRoot(),"Marcos", "Casa", "Verdes", "Marron", "lo que sea", "Estudiando fisica");
        tree.insert("Daniela", 1, 2  ,tree.getRoot(),"Daniela", "Casa", "Verdes", "Marron", "lo que sea", "Estudiando fisica");
        //tree.insert("", -1,  -1 ,tree.getRoot(),"Daniela", "Casa", "Verdes", "Marron", "lo que sea", "Estudiando fisica");
        
        
        /*FUNCIONES PARA MOSTRAR EL ARBOL*/
        System.out.println("ARBOL");
        tree.print(tree.getRoot());
        
        ListaHashTable lista = tree.buscarGeneracion(1, 0, tree.getRoot(), new ListaHashTable());
        NodoListaHashTable aux = lista.head;
        while(aux!= null){
            System.out.println(aux.nodoarbol.getNombre());
            aux = aux.next;
        }
        
        /*FUNCIONES PARA CREAR EL HASH TABLE*/
        System.out.println("HASH TABLE");
        tree.getHt().insertWithValue(tree.getRoot());
        tree.saveInHashTable(tree.getRoot());
        tree.getHt().show();
        
        
        /*ACCEDER A UN ELEMENTO DESDE EL HASH TABLE*/
        System.out.println("HIJOS 1");
        nodoarbol = tree.getHt().gettNodeById("7");
        tree.mostrarDescendientes(nodoarbol);
        
        
        System.out.println("HIJOS 2");
        nodoarbol = tree.findNodeById(16,tree.getRoot());
        tree.mostrarDescendientes(nodoarbol);
        
        
        System.out.println("BUSCAR POR NOMBRE");
        ListaHashTable lista_personas_encontrada = tree.getHt().getPersonajePorNombre("0");
        
        if(lista_personas_encontrada!= null){
             aux = lista_personas_encontrada.head;
            while(aux!=null){
                System.out.println(aux.val);
                aux = aux.next;
            }
        }
        
        System.out.println("BUSCAR POR MOTE");
        lista_personas_encontrada = tree.getHt().getPersonajePorMote("mote 9");
        
        if(lista_personas_encontrada!= null){
             aux = lista_personas_encontrada.head;
            while(aux!=null){
                System.out.println(aux.nodoarbol.getMote());
                aux = aux.next;
            }
       }
        
        System.out.println("ARBOLES HT DESCNEDIENTES");
        nodoarbol = tree.getHt().gettNodeById("Jhon Snow");
        tree.mostrarDescendientes(nodoarbol);
        

        System.out.println("ARBOLES HT ANCESTROS");
        nodoarbol = tree.getHt().gettNodeById("Marcos");
        NodoListaHashTable a = tree.mostrarAncestros(nodoarbol, new ListaHashTable()).head;
        while(a != null){
            System.out.println(a.nodoarbol.getMote());
            a = a.next;
        }
        
        
        
        
        System.setProperty("org.graphstream.ui", "swing");
       MostrarArboles Arbol = new MostrarArboles();
       Arbol.mostrar(tree);
        
        //MostrarArboles Arbol2 = new MostrarArboles();
        //Arbol2.mostrarVisualAncestros(nodoarbol);
        
        
        
    }
        
    }
    
    
    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author Edgar
 */
public class Tree {

    private NodoLista root; //Raiz 
    private int keyCounter; //Contador de claves
    private HashTable ht; //Tabla hash que asocia al arbol

    
    //CONSTRUCTORES
    
    public Tree() {
        this.root = null;
        this.keyCounter = 0;
        this.ht = new HashTable();
    }

    public HashTable getHt() {
        return ht;
    }

    public void setHt(HashTable ht) {
        this.ht = ht;
    }

    public NodoLista getRoot() {
        return root;
    }

    public void setRoot(NodoLista root) {
        this.root = root;
    }

    public int getKeyCounter() {
        return keyCounter;
    }

    public void setKeyCounter(int keyCounter) {
        this.keyCounter = keyCounter;
    }

    public boolean isEmpty() {
        return getRoot() == null;
    }

    //Mètodo que inserta un nuevo nodo en el arbol
    
    public NodoLista insert(String element, int fatherKey, int motherKey, NodoLista pointer, String mote, String heldTitle, String eyeColor, String hairColor, String notes, String fate) {
        //fk 5 pointer 5 element 21
        NodoLista nodo = new NodoLista(element, getKeyCounter(), mote, heldTitle, eyeColor, hairColor, notes, fate);
        
        //Crea un nuevo nodo con los atributos establecidos
        if (isEmpty()) {
            setRoot(nodo);
        } else {
            if (pointer.getKey() == fatherKey) {
                increaseSons(pointer, nodo); //Aumenta los hijos del padre con esta funcion
                nodo.setParent(pointer); //establece con set el padre del nodo creado
                
                NodoLista motherNode = findNodeById(motherKey, root);
                if (motherNode != null) {
                    increaseSons(motherNode, nodo); //Aumenta los hijos de la madre con esta funcion
                    nodo.setMother(motherNode); //establece con set la madre del nodo creado.
                }

                //Recurre a los hijos para conocer padre y madre
            } else {
                for (NodoLista son : pointer.getSons()) {
                    insert(element, fatherKey, motherKey, son, mote, heldTitle, eyeColor, hairColor, notes, fate);
                }
            }
        }
        keyCounter++; 
        return nodo; //returna el nuevo nodo
    }

    public void increaseSons(NodoLista father, NodoLista nodo) {
        //auemnta los hijos en el arreglo para el padre
        
        NodoLista[] newSons = new NodoLista[father.getSons().length + 1];
        for (int i = 0; i < father.getSons().length; i++) {
            newSons[i] = father.getSons()[i];
        }
        newSons[newSons.length - 1] = nodo; //añade el hijo
        father.setSons(newSons); // setea el nuevo hijo
    }

    public void print(NodoLista nodo) {
        if (isEmpty()) {
            System.out.println("The tree is empty");
        } else {
            System.out.println("KEY: " + nodo.getKey() + " VAL: " + "[" + nodo.getNombre() + "]");
            for (NodoLista son : nodo.getSons()) {
                print(son);
            }
        }
    }

    public void saveInHashTable(NodoLista nodo) { //guarda el valor del nodo hijo en la tabla del HT
        if (isEmpty()) {
            System.out.println("The tree is empty");
        } else {
            for (NodoLista son : nodo.getSons()) {
                ht.insertWithValue(son);
                saveInHashTable(son);
            }
        }
    }

    public NodoLista findNodeById(int id, NodoLista node) { //encuentra los nodos por clave
        if (node == null) {
            return null;
        }

        if (node.getKey() == id) {
            return node;
        }

        for (NodoLista son : node.getSons()) {
            NodoLista found = findNodeById(id, son);
            if (found != null) {
                return found;
            }
        }

        return null;
    }

    public void mostrarDescendientes(NodoLista node) { //retorna los descedientes
        if (node == null) {
            return;
        }
        System.out.println("Descendant: [" + node.getNombre() + "]"); //Devuelve los descendientes obteniendo el nombre del nodo

        for (NodoLista son : node.getSons()) {
            mostrarDescendientes(son); // se llama a la funcion para mostrar el descendiente
        }
    }

    //Bugg resuelto
    public ListaHashTable mostrarAncestros(NodoLista nodo, ListaHashTable ancestros) {
        /*
        Metodo para mostrar los ancestro recibiendo el nodo y su lista de ancrestro
        */
        if (nodo == null) {
            return ancestros;
            /*
            Verificar que el ancestro no existe como en metodo de buscar ancestros.
            */
        }
        if (!ancestros.buscar(nodo.getMote())) {
            ancestros.insertar(nodo);

            ancestros = mostrarAncestros(nodo.getParent(), ancestros);
            ancestros = mostrarAncestros(nodo.getMother(), ancestros);
        }
        return ancestros;
    }

    //Metodo completo, falta prueba, 6.
    public ListaHashTable buscarGeneracion(int generacion, int actual, NodoLista nodo, ListaHashTable resultado) {
        if (nodo != null) {
            if (generacion == actual) {
                resultado.insertar(nodo);
            } else {
                for (NodoLista hijo : nodo.getSons()) {
                    resultado = buscarGeneracion(generacion, actual + 1, hijo, resultado);
                }
            }
        }
        return resultado;
    }
}

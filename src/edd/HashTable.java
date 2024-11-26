/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;
/**
 *
 * @author Edgar 
 */
public class HashTable { 

    static int hashTableSize = 5000; //Tamaño de la tabla Hash
    static ListaHashTable hashTable[] = new ListaHashTable[hashTableSize];

    public HashTable() {
        for (int i = 0; i < hashTableSize; i++) {
            hashTable[i] = new ListaHashTable();
        }

    }

    public static int hashFunc(String c) {
        int hash = c.hashCode() % hashTableSize;
        if (hash < 0) {
            hash = hash * -1;
        }
        return hash;
    }

    public void insertWithValue(NodoLista nodoarbol) {
        int index = hashFunc(nodoarbol.getNombre());
        String nombreNormalizado = normalizarNombre(nodoarbol.getNombre());
        System.out.println("Insertando nodo: " + nombreNormalizado + " en índice: " + index);
        hashTable[index].insertar(nodoarbol);
    }


    public void show() {
        for (int i = 0; i < hashTableSize; i++) {

            NodoListaHashTable aux = hashTable[i].head;
            if (aux != null) {
                System.out.println("----INDICE: " + i + "------");
                while (aux != null) {
                    System.out.println("VALOR: " + aux.val);
                    aux = aux.next;
                }
                System.out.println();
            }

        }
    }

    /*
    Correcion del metodo GettNodeById 
    1.- validaciones al acceso
    2.- Condicion de comparacion cambios
    */
    public NodoLista gettNodeById(String value) {
        int index = hashFunc(value);
        System.out.println("Buscando Nodo:" + value + "En indice " + index);
        // Validar si la tabla hash y la lista en el índice existen
        if (hashTable[index] == null || hashTable[index].head == null) {
            System.out.println("Advertencia: No se encontró el índice en la tabla hash para: " + value);
            return null;
        }
        NodoListaHashTable aux = hashTable[index].head;
        
        while (aux != null) {
            if(aux.val != null && aux.val.equals(value)){
                System.out.println("Nodo encontrado: "+ value + "Indice: " + index);
                return aux.nodoarbol;
            }
            aux = aux.next;
        }

        System.out.println("ERROR: no se encontraron nodos para: "+ value);
        return null;
    }

    public void accessByKey(String value) {
        int index = hashFunc(value);

        NodoListaHashTable aux = hashTable[index].head;
        while (aux != null & aux.val != value) {
            aux = aux.next;
        }
        if (aux != null) {
            System.out.println("INDICE: " + index + " VALOR: " + aux.val + " ");
        } else {
            System.out.println("not found");
        }

    }

    //Actulizacion en complejidad de tiempo de O(n) cuadrado a O(n)
    public ListaHashTable getPersonajePorNombre(String palabra) {
        ListaHashTable nueva_lista = new ListaHashTable();
        int index = hashFunc(palabra);
        NodoListaHashTable aux = hashTable[index].head;
        while (aux != null) {
            if (aux.val.equals(palabra)) {
                nueva_lista.insertar(aux.nodoarbol);
            }
            aux = aux.next;
        }

        return nueva_lista;
    }

    public ListaHashTable getPersonajePorMote(String palabra) {
        ListaHashTable nueva_lista = new ListaHashTable();
        for (int i = 0; i < hashTableSize; i++) {
            NodoListaHashTable aux = hashTable[i].head;
            while (aux != null) {
                if (aux.nodoarbol.getMote().contains(palabra)) {
                    nueva_lista.insertar(aux.nodoarbol);
                }
                aux = aux.next;
            }
        }

        return nueva_lista;
    }

    public ListaHashTable getPersonajePorTitulo(String palabra) {
        ListaHashTable nueva_lista = new ListaHashTable(); //Creamos la lista
        /*
        Se recorre cada lista de hashTable para buscar los nodos que tengan el mismo titulo
        y se guardan en la lista, sin importar la complejidad de tiempo
        */
        for (int i = 0; i < hashTableSize; i++) {
            NodoListaHashTable aux = hashTable[i].head;
            while (aux != null) {
                if (aux.nodoarbol.getHeldTitle().equals(palabra)) {
                    nueva_lista.insertar(aux.nodoarbol);
                }
                aux = aux.next;
            }
        }
        return nueva_lista; //Retorna la lista con los nodos 
    }
    public static String normalizarNombre(String nombre) {
    if (nombre == null) {
        return null;
    }
    // Convertir a minúsculas
    String nombreNormalizado = nombre.toLowerCase();

    // Eliminar caracteres especiales no alfanuméricos
    nombreNormalizado = nombreNormalizado.replaceAll("[^a-z0-9 ]", "");

    // Eliminar espacios adicionales
    nombreNormalizado = nombreNormalizado.trim().replaceAll(" +", " ");

    return nombreNormalizado;
}
    //Metodo para validaciones de tamaño
    public int size() {
        int totalSize = 0;
        for (ListaHashTable lista : hashTable) {
            totalSize += lista.size; // Asumiendo que ListaHashTable tiene una variable `size`.
        }
        return totalSize;
    }

}

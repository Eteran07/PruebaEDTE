/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author Alejandro
 */
public class NodoLista {
    private String nombre;
    private String mote;
    private int key;
    private NodoLista[] sons;
    private NodoLista parent;
    private NodoLista mother;
    private String heldTitle; 
    private String eyeColor; 
    private String hairColor;
    private String notes;
    private String fate; 
    private final String element;
    
     public String getElement() {
        return element;
    }

    

    public String getHeldTitle() {
        return heldTitle;
    }

    public void setHeldTitle(String heldTitle) {
        this.heldTitle = heldTitle;
    }

    

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFate() {
        return fate;
    }

    public void setFate(String fate) {
        this.fate = fate;
    }
    
    public NodoLista(String element, int key, String mote, String heldTitle, String eyeColor, String hairColor, String notes, String fate) {
        this.element = element;
        this.key = key;
        this.mote = mote;
        this.heldTitle = heldTitle;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.notes = notes;
        this.fate = fate;
        this.sons = new NodoLista[0]; // Inicializa el arreglo de hijos
    }

     public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }
    public NodoLista getMother() {
        return mother;
    }

    public void setMother(NodoLista mother) {
        this.mother = mother;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public NodoLista[] getSons() {
        return sons;
    }

    public void setSons(NodoLista[] sons) {
        this.sons = sons;
    }
    
    public NodoLista getParent() {
        return parent;
    }

    public void setParent(NodoLista parent) {
        this.parent = parent;
    }

}

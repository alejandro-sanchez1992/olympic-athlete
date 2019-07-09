/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entity.Athlete;

/**
 *
 * @author Danny Alvarez
 */
public class DoubleLinkingNode {
    protected Athlete athlete; //Definir variable de objecto deportista 
    protected DoubleLinkingNode previous;
    protected DoubleLinkingNode next;

    /**
     * Double binding node data structure
     *
     * @param athlete element to be contained in the node
     */
    public DoubleLinkingNode(Athlete athlete) {
        //Constructor Para el nodo doble con objecto Deportista
        this.athlete = athlete;
        next = null;
    }
    
    // #########################################################################
    // PUBLIC METHODS  #########################################################
    // #########################################################################
    public Athlete getObject() {
        //Retornar Información del Objecto
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        //Capturar información para el objecto
        this.athlete = athlete;
    }

    public DoubleLinkingNode getPrevious() {
        //retornar Nodo Doble anterior
        return previous;
    }

    public void setPrevious(DoubleLinkingNode previous) {
        // Capturar Nodo Doble Anterior
        this.previous = previous;
    }

    public DoubleLinkingNode getNext() {
        //Retornar Nodo doble siguiente
        return next;
    }

    public void setNext(DoubleLinkingNode next) {
        //Capturar Nodo doble Siguiente
        this.next = next;
    }
}

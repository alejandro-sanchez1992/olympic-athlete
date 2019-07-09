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
public class DoublyLinkedList {

    DoubleLinkingNode first;
    DoubleLinkingNode last;
    DoubleLinkingNode selected;
    int size;

    public DoublyLinkedList() {
        first = last = selected = null;
        size = 0;
    }

    // #########################################################################
    // PUBLIC METHODS  #########################################################
    // #########################################################################
    
    public DoubleLinkingNode getFirst() {
        return first;
    }

    public void setFirst(DoubleLinkingNode first) {
        this.first = first;
    }

    public DoubleLinkingNode getLast() {
        return last;
    }

    public void setLast(DoubleLinkingNode last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }
    
    /**
     * returns the selected element inside the list
     * @return node
     */
    public DoubleLinkingNode getSelected() {
        return selected;
    }

    /**
     * sets the selected element at the first element of the list
     */
    public void goFirst() {
        selected = first;
    }
    
    /**
     * sets the selected element at the last element of the list
     */
    public void goLast() {
        selected = last;
    }
    
    /**
     * Moves the selected element to the next in the list 
     */
    public void next(){
        if(selected!=null){
            selected = selected.getNext();
        }
    }
    
    /**
     * Moves the selected element to the previous in the list 
     */
    public void previous(){
        if(selected!=null){
            selected = selected.getPrevious();
        }
    }
    
    /**
     * inserts data at the end of the list
     * @param athlete
     */
    public void pushEnd(Athlete athlete) {
        //encapsulamos el dato en un nodo doblemente ligado
        DoubleLinkingNode node = new DoubleLinkingNode(athlete);

        if (first != null) {
            //se enlaza la cola de la lista con el nuevo nodo
            last.setNext(node);
            node.setPrevious(last);

            //Se actualizan las posiciones del ultimo y el seleccionado
            last = node;
            selected = node;
        } else {
            //si la lista está vacía, se agrega el primer elemento
            first = last = selected = node;
        }
        //se incrementa el tamaño
        size++;
    }

    /**
     * inserts an element after the node passed as argument
     * @param object
     */
    public void pushAfterSelected(Athlete athlete){
        //si la lista está vacía llenamos al final
        if(first == null){
            pushEnd(athlete);
            return;//se termina el sub-programa en este caso
        }

        DoubleLinkingNode newNode = new DoubleLinkingNode(athlete);
        
        //hay 2 casos, el siguiente de selected es null o es un nodo
        if(selected.getNext() != null){
            //si hay siguiente es el caso complejo
            //debemos insertar entre 2 nodos
            //conectamos el nuevo nodo
            newNode.setNext(selected.getNext());
            newNode.setPrevious(selected);

            //actualizamos las conecciones alrededor del nuevo nodo
            selected.setNext(newNode);
            newNode.getNext().setPrevious(newNode); 
        } else {
            //si selected no tiene siguiente se actualiza unicamente 
            //el anterior del nuevo nodo
            newNode.setNext(null);//opcional
            newNode.setPrevious(selected);
            
            //actualizamos la conexión izquierda alrededor del nuevo nodo
            selected.setNext(newNode);
            
            //el nuevo nodo es el nuevo último
            last = newNode;
        }
        
        //Actualizamos el seleccionado
        selected=newNode;
        //se incrementa el tamaño
        size++;
    }
    
    /**
     * inserts an element before the node passed as argument
     * @param object 
     */
    public void pushBeforeSelected(Athlete athlete){
        //si la lista está vacía llenamos al final
        if(first == null){
            pushEnd(athlete);
            return;//se termina el sub-programa en este caso
        }
        
        DoubleLinkingNode newNode = new DoubleLinkingNode(athlete);
        
        //hay 2 casos: el anterior de selected es null o es un nodo
        if(selected.getPrevious() != null){
            //si hay anterior es el caso complejo
            //debemos insertar entre 2 nodos
            //conectamos el nuevo nodo
            newNode.setPrevious(selected.getPrevious());
            newNode.setNext(selected);
            
            //actualizamos las conecciones alrededor del nuevo nodo
            selected.getPrevious().setNext(newNode);
            selected.setPrevious(newNode);
        } else {
            //si selected no tiene anterior se actualiza unicamente 
            //el siguiente del nuevo nodo
            newNode.setPrevious(null);//opcional
            newNode.setNext(selected);
            
            //actualizamos la conexión derecha alrededor del nuevo nodo
            selected.setPrevious(newNode);
            
            //el nuevo nodo es el nuevo primer elemento
            first = newNode;
        }
        
        //Actualizamos el seleccionado
        selected=newNode;
        //se incrementa el tamaño
        size++;
    }
    
    public Object DeleteFirst() {
        Object obj = null;
        if(first == null)
            return obj;
        else
        {
            obj = first.getObject();
            if(first == last) {
                first = null;
                last = null;
            } else {
                first = first.getNext();
                first.setPrevious(null);
            }
            return obj;
        }
    }
    
    public Object DeleteLast() {
        Object obj = null;
        if(first != null)
        {
            obj = last.getObject();
            if(first == last) {
                first = null;
                last = null;
            } else {
                last=last.getPrevious();
                last.setNext(null);
            }
        }
        return obj;
    }
    
    /**
    * Removes all of the elements from this list.
    */
    public Object clear() {
        Object obj = null;
        DoubleLinkingNode aux = first;
        while (aux != null)
            aux = aux.getNext();
        
        if(aux != null) {
            if(aux.getPrevious() == null)
                obj = DeleteFirst();
            else {
                if(aux.getNext() == null)
                    obj = DeleteLast();
                else {
                    obj = aux.getObject();
                    aux.getPrevious().setNext(aux.getNext());
                    aux.getNext().setPrevious(aux.getPrevious());
                    aux = null;
                }
            }
        }
        return obj;
    }
    
    public DoublyLinkedList getListByUser() {
        DoublyLinkedList list = new DoublyLinkedList();
        DoubleLinkingNode aux = first;
        int cont = 0;
        
        while(aux != null) {
            if (cont == 3)
                cont++;
            
            if (aux.getObject().getIntCode() == cont && aux.athlete.getStrMedal().equalsIgnoreCase("oro")) {
                aux.getObject().setIntQuantity(countTotalMedal(cont));
                list.pushBeforeSelected(aux.getObject());
                cont++;
            }
            
            aux = aux.getNext();
        }

        return list;
    }
    
    public DoublyLinkedList seachBetweenValues(int value1, int value2) {
        DoublyLinkedList list = new DoublyLinkedList();
        DoubleLinkingNode aux = first;
        
        while(aux!=null) {
            if(aux.athlete.getIntQuantity() >= value1 && aux.athlete.getIntQuantity() <= value2)
                list.pushBeforeSelected(aux.athlete);
            
            aux=aux.getNext();
        }

        return list;
    }
    
    public int countTotalMedal(int id) {
        int res = 0;
        DoubleLinkingNode aux = first;
        
        while(aux != null) {
            if(aux.getObject().getIntCode() == id)
                res++;
            
            aux = aux.getNext();
        }
        return res;
    }
    
    public String getByMedal() {
        String res = "";
        DoubleLinkingNode aux = first;
        
        while(aux != null)
        {
            if(aux.getObject().getStrMedal().equalsIgnoreCase("oro"))
                res = res + aux.getObject().toString() + "\n";
            
            aux = aux.getNext();
        }
        return res;
    }
    
    public DoublyLinkedList orderListBySport() {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();
        DoublyLinkedList list3 = new DoublyLinkedList();
        DoubleLinkingNode aux = first;
        int cont = 0;
        
        while(aux != null) {
            if (aux.getObject().getIntCode() == cont) {
                aux.getObject().setIntQuantity(countTotalMedal(cont));
                if(aux.getObject().getStrSportType().equalsIgnoreCase("Taekwondo")) {
                    list2.pushBeforeSelected(aux.getObject());
                } else {
                    list1.pushBeforeSelected(aux.getObject());
                }
                cont++;
            }
            
            aux = aux.getNext();
        }
        
        DoubleLinkingNode aux1 = list1.first, aux2 = list2.first;
        
        while(aux1 != null && aux2 != null) {
            if(aux1 != null) {
                list3.pushEnd(aux1.getObject());
                aux1 = aux1.getNext();
            }
            
            if(aux2 != null) {
                list3.pushEnd(aux2.getObject());
                aux2 = aux2.getNext();
            }
        }

        return list3;
    }
    
    /**
     * Print List
     */
    @Override
    public String toString() {
        String node = "";
        DoubleLinkingNode aux = first;
        while(aux != null) {
            node = node + aux.getObject().toString() + "\n";
            aux = aux.getNext();
        }
        return node;
    }
}

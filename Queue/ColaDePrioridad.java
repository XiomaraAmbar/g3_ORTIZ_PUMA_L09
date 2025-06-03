package Queue;

import LinkedList.ListaEnlazada;
import LinkedList.MensajeException;

public class ColaDePrioridad<E> {
    private ListaEnlazada<ListaEnlazada<E>> colaPrioridad; //Se crea una nueva lista enlazada de tipo ListaEnlazada
    //Lo que sirve para almacenar listas enlazadas en cada nodo de la lista enlazada

    public ColaDePrioridad(){
        colaPrioridad = new ListaEnlazada<>();
    }

    //Verifica si la cola esta vacía
    public boolean isEmpty(){
        return colaPrioridad.isEmpty();
    }

    //Agrega el elemento x con prioridad p.
    public void enqueue(E elemento, int prioridad) throws MensajeException {
        if (isEmpty()){
            colaPrioridad.insertFirst(elemento);
        }
        else{
            cola.insertLast(elemento);
        }
    }

    //Elimina el elemento de mayor prioridad. La cola debe existir y no estar vacía.
    public E dequeue() throws MensajeException {
        E primero = front();
        cola.removeNodeK(0);
        return primero;
    }

    //Elimina los elementos de la cola dejándola vacía.
    public void destroyQueue(){
        colaPrioridad.destroyList();
    }

    //Retorna el elemento inicial de la cola
    public E front() throws MensajeException {
        return cola.searchK(0);
    }

    //Retorna el elemento final de la cola
    public E back() throws MensajeException {
        return cola.searchK(cola.length()-1);
    }

    //Verifica si la cola está llena o no. Se usa cuando la cola está implementada sobre una
    //    estructura estática.
    public void isFull(){

    }

    //Imprime la pila
    public void print() throws MensajeException {
        colaPrioridad.print();
    }
}
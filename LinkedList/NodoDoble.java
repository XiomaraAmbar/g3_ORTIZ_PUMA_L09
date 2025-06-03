package LinkedList;

public class NodoDoble<E> {
    private E valor; //Información del nodo
    private NodoDoble<E> siguiente; //Referencia al siguiente nodo o null(si la lista esta vacía)
    private NodoDoble<E> anterior; //Referencia al anterior nodo

    //Constructor que inicializa la información del nodo con su valor y la referencia del
    //siguiente apunta a null
    public NodoDoble(E valor){
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
    }

    public E getValor(){
        return valor;
    } //Retorna valor o la información del nodo

    public void setValor(E valor){
        this.valor = valor;
    } //Modifica el valor del nodo

    public NodoDoble<E> getSiguiente(){
        return siguiente;
    } //Retorna la referencia del siguiente del nodo

    public void setSiguiente(NodoDoble<E> siguiente){
        this.siguiente = siguiente;
    } //Modifica la referencia del siguiente al nodo

    public NodoDoble<E> getAnterior(){
        return anterior;
    } //Retorna la referencia del anterior nodo

    public void setAnterior(NodoDoble<E> anterior){
        this.anterior = anterior;
    } //Modifica la referencia del anterior nodo
}

package Queue;

public class NodoPrioridad<E> {
    private E valor; //Información del nodo
    private int prioridad; // Nivel de prioridad o peso del nodo
    private NodoPrioridad<E> siguiente; //Referencia al siguiente nodo o null(si la lista esta vacía)

    //Constructor que inicializa la información del nodo con su valor y la referencia del
    //siguiente apunta a null
    public NodoPrioridad(E valor, int prioridad){
        this.valor = valor;
        this.prioridad = prioridad;
        this.siguiente = null;
    }

    public E getValor(){
        return valor;
    } //Retorna valor o la información del nodo

    public void setValor(E valor){
        this.valor = valor;
    } //Modifica el valor del nodo

    public NodoPrioridad<E> getSiguiente(){
        return siguiente;
    } //Retorna la referencia del siguiente del nodo

    public void setSiguiente(NodoPrioridad<E> siguiente){
        this.siguiente = siguiente;
    } //Modifica la referencia del siguiente al nodo

    public int getPrioridad(){
        return prioridad;
    }

    public void setPrioridad(int nuevaPrioridad){
        this.prioridad = nuevaPrioridad;
    }

    public String toString() {
        return "(" + valor + ", " + prioridad + ")";
    }
}

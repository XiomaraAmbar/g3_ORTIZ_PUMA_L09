package graph;

import LinkedList.ListaEnlazada;
import LinkedList.MensajeException;

public class GraphLink<E> {
    protected ListaEnlazada<Vertex<E>> listaVertex;
    protected int[][] matrizAdyacencia;

    public GraphLink(){
        listaVertex = new ListaEnlazada<>();
    }

    //Inserta un nuevo vértice al grafo
    public void insertVertex(E data) throws MensajeException {
        Vertex<E> nuevoVertice = new Vertex<E>(data);
        listaVertex.insertLast(nuevoVertice); //Lo agrega al final de la lista de vértices
    }

    //Inserta una arista entre dos vértices existentes
    public void insertEdge(E verOri, E verDes) throws MensajeException {
        Vertex<E> verticeOrigen = getVertex(verOri);
        Vertex<E> verticeDestino = getVertex(verDes);

        //Solo inserta la arista si ambos vértices existen
        if (verticeOrigen != null && verticeDestino != null) {
            Edge<E> nuevaArista = new Edge<>(verticeDestino);
            verticeOrigen.listaAdyacencia.insertLast(nuevaArista); //Agrega la arista a la lista de adyacencia del origen
        }
    }

    //Metodo auxiliar para obtener un vértice
    private Vertex<E> getVertex(E v) throws MensajeException {
        for (int i = 0; i < listaVertex.length(); i++) { //Recorre la lista de vértices buscando el vértice
            Vertex<E> verticeTemporal = listaVertex.searchK(i); //Obtiene el vértice en la posición i
            if (verticeTemporal.getData().equals(v)) {
                return verticeTemporal; //Retorna si encuentra coincidencia
            }
        }
        return null; //No se encontró el vértice
    }

    //Verifica si un vértice con el dato 'v' existe en el grafo
    public boolean searchVertex(E v) throws MensajeException {
        for (int i = 0; i < listaVertex.length(); i++) {
            Vertex<E> verticeTemporal = listaVertex.searchK(i);
            if (verticeTemporal.getData().equals(v)) {
                return true; //Se encontró el vértice
            }
        }
        return false; //No se encontró el vértice
    }

    //Verifica si existe una arista desde el vértice 'v' al vértice 'z'
    public boolean searchEdge(E v, E z) throws MensajeException {
        Vertex<E> verticeOrigen = getVertex(v);

        if (verticeOrigen == null) {
            return false; //El vértice origen no existe
        }

        for (int i = 0; i < verticeOrigen.listaAdyacencia.length(); i++) { //Recorre la lista de adyacencia del vértice origen
            Edge<E> arista = verticeOrigen.listaAdyacencia.searchK(i);
            if (arista.getReferenciaDestino().getData().equals(z)) { //Compara si el destino de la arista tiene el dato 'z'
                return true; //Encontró la arista
            }
        }
        return false; //No encontró la arista
    }

    public String toString(){
        return this.listaVertex.toString();
    }
}
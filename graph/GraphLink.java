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

    /*
    Metodo auxiliar que construye dinámicamente una
    lista con todas las aristas del grafo
    */
    private ListaEnlazada<Edge<E>> getEdges() throws MensajeException {
        ListaEnlazada<Edge<E>> ListaEdge = new ListaEnlazada<>();

        //Recorre todos los vértices
        for (int i = 0; i < listaVertex.length(); i++) {
            Vertex<E> verticeTemporal = listaVertex.searchK(i);

            //Recorre todas las aristas de este vértice
            for (int j = 0; j < verticeTemporal.listaAdyacencia.length(); j++) {
                Edge<E> arista = verticeTemporal.listaAdyacencia.searchK(j);
                ListaEdge.insertLast(arista);
            }
        }
        return ListaEdge;
    }


    //Elimina el vértice 'v' y todas sus aristas de entrada y salida
    public boolean removeVertex(E v) throws MensajeException {
        if (!searchVertex(v)) {
            return false; //El vértice no existe
        }

        for (int i = 0; i < listaVertex.length(); i++) {
            Vertex<E> verticeTemporal = listaVertex.searchK(i);
            removeEdgeLista(verticeTemporal.listaAdyacencia, v);
        }

        //Elimina el vértice de la lista principal
        Vertex<E> verticeEliminado = getVertex(v);
        if (verticeEliminado != null) {
            listaVertex.removeNode(verticeEliminado);
            return true;
        }

        return false;
    }

    //Método auxiliar para eliminar una arista específica de una lista de adyacencia
    private void removeEdgeLista(ListaEnlazada<Edge<E>> listaAristas, E destinoBuscado) throws MensajeException {
        for (int i = 0; i < listaAristas.length(); i++) {
            Edge<E> arista = listaAristas.searchK(i);
            if (arista.getReferenciaDestino().getData().equals(destinoBuscado)) {
                listaAristas.removeNode(arista);
                break;
            }
        }
    }

    //Elimina la arista que une los vértices 'v' y 'z'
    public boolean removeEdge(E v, E z) throws MensajeException {
        if (!searchVertex(v) || !searchVertex(z)) {
            return false;
        }

        if (!searchEdge(v, z)) {
            return false;
        }

        Vertex<E> verticeOrigen = getVertex(v); //Obtiene el vértice origen

        //Eliminar la arista de la lista de adyacencia
        removeEdgeLista(verticeOrigen.listaAdyacencia, z);

        return true;
    }


    public String toString(){
        return this.listaVertex.toString();
    }
}

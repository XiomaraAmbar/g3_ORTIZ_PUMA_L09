package graph;

public class Edge<E> {
    private Vertex<E> referenciaDestino;
    private int weight;

    public Edge(Vertex<E> refDest){
        this(refDest,-1);
    }

    public Edge(Vertex<E> refDest, int weight){
        this.referenciaDestino = refDest;
        this.weight = weight;
    }

    public Vertex<E> getReferenciaDestino() {
        return referenciaDestino;
    }

    public boolean equals(Object o){
        if (o instanceof Edge<?>) {
            Edge<E> e = (Edge<E>) o;
            return this.referenciaDestino.equals(e.referenciaDestino);
        }
        return false;
    }
    public String toString(){
        if (this.weight > -1) {
            return referenciaDestino.getData() + " [" + this.weight + "],";
        }
        return referenciaDestino.getData() + " [No Weight],";
    }
}
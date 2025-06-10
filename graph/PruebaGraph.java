package graph;

import LinkedList.MensajeException;

public class PruebaGraph {

    public static void main(String[] args) {
        try {
            //Grafo de enteros
            GraphLink<Integer> grafoEnteros = new GraphLink<>();

            System.out.println(">>>> PRUEBA DE GRAPHLINK <<<<\n");

            //Prueba 1: Insertar vértices
            System.out.println("Prueba 1: Insertando vértices: ");
            grafoEnteros.insertVertex(1);
            grafoEnteros.insertVertex(2);
            grafoEnteros.insertVertex(3);
            grafoEnteros.insertVertex(4);
            System.out.println("Vértices insertados: 1, 2, 3, 4");
            System.out.println("Grafo actual: " + grafoEnteros.toString());
            System.out.println();

            //Prueba 2: Buscar vértices
            System.out.println("Prueba 2: Buscando vértices: ");
            System.out.println("¿Existe vértice 1? " + grafoEnteros.searchVertex(1));
            System.out.println("¿Existe vértice 3? " + grafoEnteros.searchVertex(3));
            System.out.println("¿Existe vértice 5? " + grafoEnteros.searchVertex(5));
            System.out.println();

            //Prueba 3: Insertar aristas
            System.out.println("Prueba 3: Insertando aristas: ");
            grafoEnteros.insertEdge(1, 2); //1 -> 2
            grafoEnteros.insertEdge(1, 3); //1 -> 3
            grafoEnteros.insertEdge(2, 4); //2 -> 4
            grafoEnteros.insertEdge(3, 4); //3 -> 4
            System.out.println("Aristas insertadas: 1->2, 1->3, 2->4, 3->4");
            System.out.println();

            //Prueba 4: Buscar aristas
            System.out.println("Prueba 4: Buscando aristas: ");
            System.out.println("¿Existe arista 1->2? " + grafoEnteros.searchEdge(1, 2));
            System.out.println("¿Existe arista 1->3? " + grafoEnteros.searchEdge(1, 3));
            System.out.println("¿Existe arista 2->1? " + grafoEnteros.searchEdge(2, 1)); //No existe (grafo dirigido)
            System.out.println("¿Existe arista 1->4? " + grafoEnteros.searchEdge(1, 4)); //No existe directamente
            System.out.println("¿Existe arista 4->1? " + grafoEnteros.searchEdge(4, 1)); //No existe
            System.out.println();

            //Prueba 5: Intentar insertar arista con vértice inexistente
            System.out.println("Prueba 5: Intentando insertar arista con vértice inexistente: ");
            grafoEnteros.insertEdge(1, 5); //El vértice 5 no existe
            System.out.println("Intento de insertar arista 1->5 (vértice 5 no existe)");
            System.out.println("¿Existe arista 1->5? " + grafoEnteros.searchEdge(1, 5));
            System.out.println();

            //Prueba 6: Grafo con strings
            System.out.println("Prueba 6: Probando con grafo de strings: ");
            GraphLink<String> grafoString = new GraphLink<>();

            grafoString.insertVertex("A");
            grafoString.insertVertex("B");
            grafoString.insertVertex("C");

            grafoString.insertEdge("A", "B");
            grafoString.insertEdge("B", "C");
            grafoString.insertEdge("A", "C");

            System.out.println("Grafo de strings: " + grafoString.toString());
            System.out.println("¿Existe vértice 'A'? " + grafoString.searchVertex("A"));
            System.out.println("¿Existe arista A->B? " + grafoString.searchEdge("A", "B"));
            System.out.println("¿Existe arista C->A? " + grafoString.searchEdge("C", "A"));
            System.out.println();

            //Prueba 7: Grafo vacío
            System.out.println("Prueba 7: Probando con grafo vacío: ");
            GraphLink<Integer> grafoVacio = new GraphLink<>();
            System.out.println("¿Existe vértice 1 en grafo vacío? " + grafoVacio.searchVertex(1));
            System.out.println("¿Existe arista 1->2 en grafo vacío? " + grafoVacio.searchEdge(1, 2));
            System.out.println();

            System.out.println(">>>> PRUEBAS COMPLETADAS <<<<");

        } catch (MensajeException e) {
            System.err.println("Error durante las pruebas: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
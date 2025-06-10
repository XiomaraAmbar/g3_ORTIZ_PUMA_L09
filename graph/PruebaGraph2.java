package graph;

import LinkedList.MensajeException;

public class PruebaGraph2 {

    public static void main(String[] args) {
        try {
            //Grafo de enteros
            GraphLink<Integer> grafoEnteros = new GraphLink<>();

            System.out.println(">>>> PRUEBA REMOVE DE GRAPHLINK <<<<\n");

            //Prueba 1: Insertar vértices
            System.out.println("Prueba 1: Insertando vértices: ");
            grafoEnteros.insertVertex(1);
            grafoEnteros.insertVertex(2);
            grafoEnteros.insertVertex(3);
            grafoEnteros.insertVertex(4);
            grafoEnteros.insertVertex(5);
            System.out.println("Vértices insertados: 1, 2, 3, 4, 5");
            System.out.println("Grafo actual: " + grafoEnteros.toString());
            System.out.println();

            //Prueba 2: Insertar aristas
            System.out.println("Prueba 2: Insertando aristas: ");
            grafoEnteros.insertEdge(1, 2); //1 -> 2
            grafoEnteros.insertEdge(1, 3); //1 -> 3
            grafoEnteros.insertEdge(2, 4); //2 -> 4
            grafoEnteros.insertEdge(3, 4); //3 -> 4
            grafoEnteros.insertEdge(4, 5); //4 -> 5
            grafoEnteros.insertEdge(3, 5); //3 -> 5
            grafoEnteros.insertEdge(1, 4); //1 -> 4
            System.out.println("Aristas insertadas: 1->2, 1->3, 2->4, 3->4, 4->5, 3->5, 1->4");
            System.out.println("Grafo después de insertar aristas: " + grafoEnteros.toString());
            System.out.println();

            //Prueba 3: Verificar aristas existentes
            System.out.println("Prueba 3: Verificando aristas existentes: ");
            System.out.println("¿Existe arista 1->2? " + grafoEnteros.searchEdge(1, 2));
            System.out.println("¿Existe arista 1->3? " + grafoEnteros.searchEdge(1, 3));
            System.out.println("¿Existe arista 1->4? " + grafoEnteros.searchEdge(1, 4));
            System.out.println("¿Existe arista 3->5? " + grafoEnteros.searchEdge(3, 5));
            System.out.println("¿Existe arista 4->5? " + grafoEnteros.searchEdge(4, 5));
            System.out.println("¿Existe arista 2->1? " + grafoEnteros.searchEdge(2, 1)); //No existe (grafo dirigido)
            System.out.println();

            //Prueba 4: Eliminar aristas específicas
            System.out.println("Prueba 4: Eliminando aristas específicas: ");

            System.out.println("Eliminando arista 1->2...");
            boolean resultado1 = grafoEnteros.removeEdge(1, 2);
            System.out.println("¿Se eliminó exitosamente? " + resultado1);
            System.out.println("¿Existe arista 1->2 después de eliminar? " + grafoEnteros.searchEdge(1, 2));

            System.out.println("Eliminando arista 3->4...");
            boolean resultado2 = grafoEnteros.removeEdge(3, 4);
            System.out.println("¿Se eliminó exitosamente? " + resultado2);
            System.out.println("¿Existe arista 3->4 después de eliminar? " + grafoEnteros.searchEdge(3, 4));

            System.out.println("Intentando eliminar arista inexistente 2->1...");
            boolean resultado3 = grafoEnteros.removeEdge(2, 1);
            System.out.println("¿Se eliminó exitosamente? " + resultado3);
            System.out.println();

            //Prueba 5: Intentar eliminar arista con vértices inexistentes
            System.out.println("Prueba 5: Intentando eliminar arista con vértices inexistentes: ");
            System.out.println("Intentando eliminar arista 1->10 (vértice 10 no existe)...");
            boolean resultado4 = grafoEnteros.removeEdge(1, 10);
            System.out.println("¿Se eliminó exitosamente? " + resultado4);

            System.out.println("Intentando eliminar arista 15->3 (vértice 15 no existe)...");
            boolean resultado5 = grafoEnteros.removeEdge(15, 3);
            System.out.println("¿Se eliminó exitosamente? " + resultado5);
            System.out.println();

            //Prueba 6: Estado actual del grafo antes de eliminar vértices
            System.out.println("Prueba 6: Estado actual del grafo: ");
            System.out.println("Grafo actual: " + grafoEnteros.toString());
            System.out.println("Aristas que deberían existir:");
            System.out.println("- 1->3: " + grafoEnteros.searchEdge(1, 3));
            System.out.println("- 1->4: " + grafoEnteros.searchEdge(1, 4));
            System.out.println("- 2->4: " + grafoEnteros.searchEdge(2, 4));
            System.out.println("- 3->5: " + grafoEnteros.searchEdge(3, 5));
            System.out.println("- 4->5: " + grafoEnteros.searchEdge(4, 5));
            System.out.println();

            //Prueba 7: Eliminar vértice con sus aristas
            System.out.println("Prueba 7: Eliminando vértice 4 (debe eliminar todas sus aristas de entrada y salida): ");
            System.out.println("Antes de eliminar vértice 4:");
            System.out.println("- ¿Existe vértice 4? " + grafoEnteros.searchVertex(4));
            System.out.println("- ¿Existe arista 1->4? " + grafoEnteros.searchEdge(1, 4));
            System.out.println("- ¿Existe arista 2->4? " + grafoEnteros.searchEdge(2, 4));
            System.out.println("- ¿Existe arista 4->5? " + grafoEnteros.searchEdge(4, 5));

            boolean verticeEliminado = grafoEnteros.removeVertex(4);
            System.out.println("\n¿Se eliminó el vértice 4 exitosamente? " + verticeEliminado);

            System.out.println("Después de eliminar vértice 4:");
            System.out.println("- ¿Existe vértice 4? " + grafoEnteros.searchVertex(4));
            System.out.println("- ¿Existe arista 1->4? " + grafoEnteros.searchEdge(1, 4));
            System.out.println("- ¿Existe arista 2->4? " + grafoEnteros.searchEdge(2, 4));
            System.out.println("- ¿Existe arista 4->5? " + grafoEnteros.searchEdge(4, 5));
            System.out.println("Grafo después de eliminar vértice 4: " + grafoEnteros.toString());
            System.out.println();

            //Prueba 8: Intentar eliminar vértice inexistente
            System.out.println("Prueba 8: Intentando eliminar vértice inexistente: ");
            boolean verticeInexistente = grafoEnteros.removeVertex(10);
            System.out.println("¿Se eliminó el vértice 10 (inexistente)? " + verticeInexistente);
            System.out.println();

            //Prueba 9: Eliminar vértice aislado (sin aristas)
            System.out.println("Prueba 9: Agregando y eliminando vértice aislado: ");
            grafoEnteros.insertVertex(6);
            System.out.println("Vértice 6 agregado (sin aristas)");
            System.out.println("¿Existe vértice 6? " + grafoEnteros.searchVertex(6));

            boolean verticeAislado = grafoEnteros.removeVertex(6);
            System.out.println("¿Se eliminó el vértice 6 aislado? " + verticeAislado);
            System.out.println("¿Existe vértice 6 después de eliminar? " + grafoEnteros.searchVertex(6));
            System.out.println();

            //Prueba 10: Estado final del grafo
            System.out.println("Prueba 10: Estado final del grafo: ");
            System.out.println("Grafo final: " + grafoEnteros.toString());
            System.out.println("Vértices que deberían existir: 1, 2, 3, 5");
            System.out.println("- ¿Existe vértice 1? " + grafoEnteros.searchVertex(1));
            System.out.println("- ¿Existe vértice 2? " + grafoEnteros.searchVertex(2));
            System.out.println("- ¿Existe vértice 3? " + grafoEnteros.searchVertex(3));
            System.out.println("- ¿Existe vértice 5? " + grafoEnteros.searchVertex(5));
            System.out.println("Aristas que deberían existir:");
            System.out.println("- 1->3: " + grafoEnteros.searchEdge(1, 3));
            System.out.println("- 3->5: " + grafoEnteros.searchEdge(3, 5));
            System.out.println();

            //Prueba 11: Grafo con strings - Pruebas de eliminación
            System.out.println("Prueba 11: Pruebas de eliminación con grafo de strings: ");
            GraphLink<String> grafoString = new GraphLink<>();

            grafoString.insertVertex("A");
            grafoString.insertVertex("B");
            grafoString.insertVertex("C");
            grafoString.insertVertex("D");

            grafoString.insertEdge("A", "B");
            grafoString.insertEdge("B", "C");
            grafoString.insertEdge("A", "C");
            grafoString.insertEdge("C", "D");
            grafoString.insertEdge("A", "D");

            System.out.println("Grafo de strings inicial: " + grafoString.toString());
            System.out.println("Aristas: A->B, B->C, A->C, C->D, A->D");

            System.out.println("\nEliminando arista A->B...");
            System.out.println("¿Se eliminó A->B? " + grafoString.removeEdge("A", "B"));
            System.out.println("¿Existe A->B después? " + grafoString.searchEdge("A", "B"));

            System.out.println("\nEliminando vértice C (debe eliminar B->C, A->C, C->D)...");
            System.out.println("¿Se eliminó vértice C? " + grafoString.removeVertex("C"));
            System.out.println("¿Existe vértice C? " + grafoString.searchVertex("C"));
            System.out.println("¿Existe A->C? " + grafoString.searchEdge("A", "C"));
            System.out.println("¿Existe B->C? " + grafoString.searchEdge("B", "C"));
            System.out.println("¿Existe C->D? " + grafoString.searchEdge("C", "D"));
            System.out.println("¿Existe A->D? " + grafoString.searchEdge("A", "D")); //Debe seguir existiendo

            System.out.println("Grafo de strings final: " + grafoString.toString());
            System.out.println();

            //Prueba 12: Casos extremos
            System.out.println("Prueba 12: Casos extremos: ");

            //Crear grafo con un solo vértice
            GraphLink<Integer> grafoUnico = new GraphLink<>();
            grafoUnico.insertVertex(100);

            System.out.println("Grafo con un solo vértice: " + grafoUnico.toString());
            System.out.println("Eliminando el único vértice...");
            System.out.println("¿Se eliminó? " + grafoUnico.removeVertex(100));
            System.out.println("Grafo después de eliminar único vértice: " + grafoUnico.toString());

            //Intentar operaciones en grafo vacío
            System.out.println("\nOperaciones en grafo vacío:");
            GraphLink<Integer> grafoVacio = new GraphLink<>();
            System.out.println("¿Se eliminó vértice en grafo vacío? " + grafoVacio.removeVertex(1));
            System.out.println("¿Se eliminó arista en grafo vacío? " + grafoVacio.removeEdge(1, 2));

            System.out.println();
            System.out.println(">>>> TODAS LAS PRUEBAS COMPLETADAS EXITOSAMENTE <<<<");

        } catch (MensajeException e) {
            System.err.println("Error durante las pruebas: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
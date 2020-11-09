package vuelos;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        //Creo la data para ser analizada por el camino minimo
        Vertex EZE = new Vertex("Ezeiza");
        Vertex MIA = new Vertex("Miami");
        Vertex GRU = new Vertex("Sao Paulo");
        Vertex JFK = new Vertex("New York - JFK");

        EZE.addNeighbour(new Edge(EZE, MIA, 123000, 9.2));
        EZE.addNeighbour(new Edge(EZE, GRU, 30000, 3));
        EZE.addNeighbour(new Edge(EZE, JFK, 155000, 11));

        MIA.addNeighbour(new Edge(MIA, GRU, 90000, 4));
        MIA.addNeighbour(new Edge(MIA, JFK, 25000, 3));

        Dijkstra dijkstra = new Dijkstra();
        //Genera toda la data de caminos minimos desde este Vertex o Nodo
        dijkstra.computePath(EZE);
        //Imprime el camino minimo desde el vertex/Node anterior y este:
        System.out.println(dijkstra.getShortestPathTo(JFK));


        //Esto lo traje del anterior:
        //Cargo todos los vuelos del archivo y los muestro
        LoadFlights.load();
        //obtengo de cada Vertex/node y Edge  
        // for(Vertex vertex: LoadFlights.getVertex()){
        //     for(Edge edge: LoadFlights.getFlights()){
        //         if(vertex.equals(edge.getTargetVertex())){
        //             vertex.addNeighbour(edge);
        //         }
        //     }
        // }
        // //Muestro todos los Vertex/nodes que tengo para analizar
        // for(Vertex vertex: LoadFlights.getVertex()){
        //     System.out.println(vertex);
        // }
    }
}
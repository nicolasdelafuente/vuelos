package vuelos;

import java.io.IOException;



public class MapRepresentation {
 
    public static Graph getCities() throws IOException 
    {
        LoadFlights.load();
        // for(Edge edge : LoadFlights.getFlights())
        //     System.out.println(edge);
        // for(Node node : LoadFlights.getNodes())
        //     System.out.println(node);
        for(Node node: LoadFlights.getNodes()){
            for(Edge edge: LoadFlights.getFlights()){
                if(node.equals(edge.getOrigin())){
                    node.addEdge(edge);
                }
            }
        }

        for(Node node: LoadFlights.getNodes()){
            System.out.println(node);
        }

        // Graph graph = new Graph();
        // graph.addNode(EZE);
        // graph.addNode(MIA);
        // graph.addNode(GRU);
        // graph.addNode(LAX);
        // return graph;
        return null;
    }
 
    public static void main(String[] args) throws IOException 
    {
        Graph graph = getCities();
        //System.out.println(graph);
    }
}
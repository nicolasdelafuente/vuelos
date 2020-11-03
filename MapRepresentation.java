package vuelos;

public class MapRepresentation {
 
    public static Graph getCities() 
    {
        Node EZE = new Node("Ezeiza");
        Node MIA = new Node("Miami");
        Node GRU = new Node("Sao Paulo");
        Node LAX = new Node("Los Angeles");
        Node JFK = new Node("New York");
 
        EZE.addEdge(new Edge(EZE, MIA, 9.2));
        EZE.addEdge(new Edge(EZE, GRU, 3));
        EZE.addEdge(new Edge(EZE, LAX, 11));
        EZE.addEdge(new Edge(EZE, JFK, 10));

        MIA.addEdge(new Edge(MIA, JFK, 2));
        MIA.addEdge(new Edge(MIA, GRU, 6));
        MIA.addEdge(new Edge(MIA, LAX, 5));

        GRU.addEdge(new Edge(GRU, LAX, 8));
        LAX.addEdge(new Edge(LAX, JFK, 4));

 
        Graph graph = new Graph();
        graph.addNode(EZE);
        graph.addNode(MIA);
        graph.addNode(GRU);
        graph.addNode(LAX);
        return graph;
    }
 
    public static void main(String[] args) 
    {
        Graph graph = getCities();
        System.out.println(graph);
    }
}
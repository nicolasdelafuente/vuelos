package vuelos;

public class Edge {
    
    private Vertex startVertex;
    private Vertex targetVertex;
    private double cost;
    private double hours;


    public Edge(Vertex startVertex, Vertex targetVertex, double cost, double hours) {
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
        this.cost = cost;
        this.hours = hours;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
}
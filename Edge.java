package vuelos;

/**
 * @author raidentrance
 *
 */
public class Edge 
{
    private Node origin;
    private Node destination;
    private double distance;
    private double cost;
    private double hours;
 
    public Edge(Node origin, Node destination, double distance, double cost, double hours) 
    {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.cost = cost;
        this.hours = hours;
    }
 
    public Node getOrigin() 
    {
        return origin;
    }
 
    public void setOrigin(Node origin) 
    {
        this.origin = origin;
    }
 
    public Node getDestination() 
    {
        return destination;
    }
 
    public void setDestination(Node destination) 
    {
        this.destination = destination;
    }
 
    public double getDistance() 
    {
        return distance;
    }
 
    public void setDistance(double distance) 
    {
        this.distance = distance;
    }
 
    @Override
    public String toString() 
    {
        return "\n Edge [origin=" + origin.getCity() + ", destination=" + destination.getCity() + ", distance="
                + distance + "]";
    }

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}
 
}
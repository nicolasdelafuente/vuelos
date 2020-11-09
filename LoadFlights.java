package vuelos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LoadFlights {
	private static final String FLIGHTS_FILE = "vuelos/vuelos.txt";
	private static List<Edge>flights = new ArrayList<>();
	private static List<Node>nodes = new ArrayList<>();
	
	public static void load() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(FLIGHTS_FILE));
		
		String line;
		
        while ((line = in.readLine()) != null) {
        	
        	String lineValues[] = line.split(" ");
			double cost = Double.parseDouble(lineValues[2]);
			double hours = Double.parseDouble(lineValues[3]);
			Node source = new Node(lineValues[0]);
			Node destination = new Node(lineValues[1]);
			
			Edge flight = new Edge(source, destination, 0, cost, hours);
			flights.add(flight);
			if (!nodes.contains(source)){
				nodes.add(source);
			} else if (!nodes.contains(destination)){
				nodes.add(destination);
				}
			

		}
		in.close();
	}

	public static List<Edge> getFlights() {
		return flights;
	}

	public static void setFlights(List<Edge> flights) {
		LoadFlights.flights = flights;
	}

	public static List<Node> getNodes() {
		return nodes;
	}

	public static void setNodes(List<Node> nodes) {
		LoadFlights.nodes = nodes;
	}




	
}

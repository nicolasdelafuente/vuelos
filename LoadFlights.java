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
	private static List<Vertex>vertex = new ArrayList<>();
	
	public static void load() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(FLIGHTS_FILE));
		
		String line;
		
        while ((line = in.readLine()) != null) {
        	
			String lineValues[] = line.split(" ");
			Vertex source = new Vertex(lineValues[0]);
			Vertex destination = new Vertex(lineValues[1]);
			double cost = Double.parseDouble(lineValues[2]);
			double hours = Double.parseDouble(lineValues[3]);
			System.out.println(source + " " + destination + " " + cost + " " + hours);

			
			Edge flight = new Edge(source, destination, cost, hours);
			flights.add(flight);
			if (!vertex.contains(source)){
				vertex.add(source);
			} else if (!vertex.contains(destination)){
				vertex.add(destination);
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

	public static List<Vertex> getVertex() {
		return vertex;
	}

	public static void setVertex(List<Vertex> vertexs) {
		LoadFlights.vertex = vertexs;
	}




	
}

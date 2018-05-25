package grafos2;


import java.util.Scanner;
import java.util.Set;

import org.jgrapht.Graph;

public class Search {

	private static final String line = System.lineSeparator();
	private static final Scanner sc = new Scanner(System.in);

	private static volatile Graph<Object, RelationshipEdge> graphGml = null;
	private static volatile Set<RelationshipEdge> edges = null;
	private static volatile Set<Object> vertices = null;
	
	private static void showSpecifications() {
		System.out.println("This program  is responsible to  find a path between" + line
				+ "a Manager Machine and another machine. The user only" + line
				+ "input the name of the  machine that he want find the" + line
				+ "path." + line
				+ "!Observation: As the imported graph is not directed," + line
				+ "the  edge {a, b} is equals to {b, a}.  Where a and b" + line
				+ "are any vertices of the imported GML graph.");
	}

	private static void importGraphGML() {
		graphGml = ImportSimpleGraphGML.importGraph();
		edges = graphGml.edgeSet();
		vertices = graphGml.vertexSet();

		System.out.println(line
				+ "Graph Imported from GML file:"
				+ line + "Machines: " + vertices
				+ line + "Links: " + edges);
	}

	private static void menuSearchPath() {
		System.out.println(line
				+ "-*- SHEARCH PATH MENU -*-" + line
				+ line
				+ "Enter 'E' to exit.");
		
		Object machine = readMachine();
		System.out.println(line
				+ "Better path to " + machine + ": " + FindPath.searchShortestPath(graphGml, machine));
	}

	private static String machineChoose() {
		System.out.print(line
				+ "Choose the machine> ");
		return sc.nextLine();
	}

	private static boolean validateMachine(Object machine) {
		for (Object vertex : vertices) {
			String v = String.valueOf(vertex);
			if (!v.equals("C") && v.equals(machine)) {
				return true;
			}
		}
		return false;
	}
	
	private static Object readMachine() {
		while (true) {
			String machine = machineChoose();
			if (machine.toUpperCase().equals("E")) 
				System.exit(0);
			if (validateMachine(machine)) {
				return machine;
			}
			System.out.println(line
					+ "The name insert is not valid." + line
					+ "Please, enter a valid machine.");
		}
	}

	public static void main(String[] args) {
		showSpecifications();
		importGraphGML();
		while (true) {
			menuSearchPath();
		}
	}

}

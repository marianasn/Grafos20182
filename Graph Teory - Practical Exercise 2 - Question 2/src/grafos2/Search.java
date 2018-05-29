package grafos2;

import java.util.Scanner;
import java.util.Set;

import org.jgrapht.Graph;

/**
 * @author Abel Antunes
 * @author José Guilherme
 * @author Mariana Nascimento
 * @author Siuanny Barbosa
 * 
 *         This is the main class of the program.
 * 
 */
public class Search {

	private static final String line = System.lineSeparator();
	private static final Scanner sc = new Scanner(System.in);

	private static volatile Graph<Object, RelationshipEdge> graphGml = null;
	private static volatile Set<RelationshipEdge> edges = null;
	private static volatile Set<Object> vertices = null;

	/**
	 * This method shows the program specifications.
	 */
	private static void showSpecifications() {
		System.out.println("This program  is responsible to  find a path between" + line
				+ "a Manager Machine and another machine. The user only needs" + line
				+ "to input the name of the  machine that he wants to find the" + line + "path." + line
				+ "!Observation: As the imported graph is not directed," + line
				+ "the  edge {a, b} is equals to {b, a}.  Where a and b" + line
				+ "are any vertices of the imported GML graph.");
	}

	/**
	 * This method imports the simpleGraph from the class ImportSimpleGraphGML and
	 * prints the Machines and Links.
	 * 
	 */
	private static void importGraphGML() {
		graphGml = ImportSimpleGraphGML.importGraph();
		edges = graphGml.edgeSet();
		vertices = graphGml.vertexSet();

		System.out.println(
				line + "Graph Imported from GML file:" + line + "Machines: " + vertices + line + "Links: " + edges);
	}

	/**
	 * This method reads the Machine that the user wants to know the path
	 * and prints the better path for the Machine. (To find the better path, the method
	 * access another method in the class FindPath).
	 */
	private static void menuSearchPath() {
		System.out.println(line + "-*- SHEARCH PATH MENU -*-" + line + line + "Enter 'E' to exit.");

		Object machine = readMachine();
		System.out.println(line + "Better path to " + machine + ": " + FindPath.searchShortestPath(graphGml, machine));
	}

	/**
	 * This method prints the command to choose the machine.
	 * @return the machine selected
	 */
	private static String machineChoose() {
		System.out.print(line + "Choose the machine> ");
		return sc.nextLine();
	}
	/**
	 * This method validates the machine entered comparing the 
	 * Object v with the string "C" and the machine. 
	 * 
	 * @param machine
	 * @return a boolean value
	 */
	private static boolean validateMachine(Object machine) {
		for (Object vertex : vertices) {
			String v = String.valueOf(vertex);
			if (!v.equals("C") && v.equals(machine)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method reads the Machine entered by the user
	 * and verifies if the Machine is valid by the method validateMachine().
	 * @return
	 */
	private static Object readMachine() {
		while (true) {
			String machine = machineChoose();
			if (machine.toUpperCase().equals("E"))
				System.exit(0);
			if (validateMachine(machine)) {
				return machine;
			}
			System.out.println(line + "The name insert is not valid." + line + "Please, enter a valid machine" + line
					+ "or enter 'E' to exit.");
		}
	}
	
	/**
	 * The main of the program using the methods in it's scope.
	 * @param args
	 */
	public static void main(String[] args) {
		showSpecifications();
		importGraphGML();
		while (true) {
			menuSearchPath();
		}
	}

}

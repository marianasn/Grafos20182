package grafos2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.io.GmlImporter;
import org.jgrapht.io.EdgeProvider;
import org.jgrapht.io.ImportException;
import org.jgrapht.io.VertexProvider;

public class ImportSimpleGraphGML {
	
	public static StringReader readFile(String filename) {
		StringBuilder contentBuilder = new StringBuilder();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				contentBuilder.append(sCurrentLine).append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		StringReader readergml = new StringReader(contentBuilder.toString());
		return readergml;
	}
	
	public static Graph<Object, RelationshipEdge> importGraph() {
		VertexProvider<Object> vp1 = (label, attributes) -> new DefaultVertex(label, attributes);
		EdgeProvider<Object, RelationshipEdge> ep1 = (from, to, label, attributes) -> new RelationshipEdge(from, to);
		GmlImporter<Object, RelationshipEdge> gmlImporter = new GmlImporter<>(vp1, ep1);
		Graph<Object, RelationshipEdge> graphgml = new SimpleGraph<>(RelationshipEdge.class);

		try {
			gmlImporter.importGraph(graphgml, readFile("/home/siuannybsr/eclipse-workspace/GraphTeory20182/Graph Teory - Practical Exercise 2 - Question 2/files/rede.gml"));
		} catch (ImportException e) {
			throw new RuntimeException(e);
		}
		return graphgml;
	}
	
}

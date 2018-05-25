package grafos2;

import java.util.Iterator;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

public class FindPath {

	public static GraphPath<Object, RelationshipEdge> searchSmallestPath(Graph<Object, RelationshipEdge> graphGml, Object sink) {
		DefaultVertex C = findMachine(graphGml, "C");
		DefaultVertex M = findMachine(graphGml, sink);
		return DijkstraShortestPath.findPathBetween(graphGml, C, M);
	}

	private static DefaultVertex findMachine(Graph<Object, RelationshipEdge> graphGml, Object sink) {
		Set<Object> vertex = graphGml.vertexSet();
		Iterator<Object> iter = vertex.iterator();
		while (true) {
		    DefaultVertex M = (DefaultVertex) iter.next();
			if (M.getLabel().equals(sink))
				return M;
		}
	}

}

package grafos2;

/**
 * @author Abel Antunes
 * @author José Guilherme
 * @author Mariana Nascimento
 * @author Siuanny Barbosa
 * 
 * This class represents de relationship between two vertices (v1,v2).
 */
public class RelationshipEdge {

	private Object v1;
	private Object v2;

	public RelationshipEdge(Object v1, Object v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	/**
	 * 
	 * @return the edge representation between v1 and v2.
	 */
	public Object getLabel() {
		return ("{" + v1 + "," + v2 + "}");
	}

	/**
	 * 
	 * @return vertex v1.
	 */
	public Object getV1() {
		return v1;
	}

	/**
	 * 
	 * @return vertex v2.
	 */
	public Object getV2() {
		return v2;
	}
	
	/**
	 * This method compares the object v to v1 and v2.
	 * 
	 * @param v
	 * @return v2, if true.
	 * 		   v1, if false.
	 */
	public Object getNeighbour(Object v) {
		return (v.equals(v1)) ? v2 : v1;
	}
	
	/**
	 * 
	 * @param e
	 * @return a boolean value for the equals method.
	 */
	public boolean equals(RelationshipEdge e) {
		return (this.getLabel()).equals(e.getLabel());
	}
	
	/**
	 * The String representation of the edge between
	 * v1 and v2.
	 */
	@Override
	public String toString() {
		return ("{" + v1 + "," + v2 + "}");
	}

}

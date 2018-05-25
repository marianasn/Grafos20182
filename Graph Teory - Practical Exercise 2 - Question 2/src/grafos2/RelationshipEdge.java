package grafos2;

public class RelationshipEdge {

	private Object v1;
	private Object v2;
	
	public RelationshipEdge(Object v1, Object v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	public Object getLabel() {
		return ("{" + v1 + "," + v2 + "}");
	}

	public Object getV1() {
		return v1;
	}

	public Object getV2() {
		return v2;
	}
	
	public Object getNeighbour(Object v) {
		return (v.equals(v1))? v2 : v1;
	}

	public boolean equals(RelationshipEdge e) {
		return (this.getLabel()).equals(e.getLabel());
	}

	@Override
	public String toString() {
		return ("{" + v1 + "," + v2 + "}");
	}

}

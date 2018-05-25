package grafos2;

import java.io.Serializable;
import java.util.Map;

import org.jgrapht.io.Attribute;

public class DefaultVertex implements Serializable {

	private static final long serialVersionUID = 1;

	private Object id;
	private Map<String, Attribute> att;

	public DefaultVertex(Object id, Map<String, Attribute> att) {
		this.id = id;
		this.att = att;
	}

	public Object getId() {
		return id;
	}

	public String getAtt() {
		return att.toString();
	}

	public void setAtt(Map<String, Attribute> att) {
		this.att = att;
	}

	public String getLabel() {
		return (att.get("label")).toString();
	}

	public String toString() {
		return (att.get("label")).toString();
	}

	public boolean equals(DefaultVertex v) {
		return this.id.equals(v.id);
	}
	
}

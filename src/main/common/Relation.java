package main.common;

/**
 * For HATEOAS Links.
 * 
 * @author "Jigar Gosalia"
 *
 */
public enum Relation {
	SELF("self");

	private String value;

	private Relation(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

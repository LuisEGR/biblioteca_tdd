package main.common;

/**
 * For Response Codes.
 * 
 * @author "Jigar Gosalia"
 *
 */
public enum Responses {
	CREATED("Created Successfully", 00000),
	DELETED("Deleted Successfully", 00000),
	UPDATED("Updated Successfully", 00000),
	NO_DATA("No Data Available", 10000),
	ALREADY_EXISTS("Already Exists", 10001),
	BAD_REQUEST("Bad Request", 10002),
	DOESNT_EXISTS("Doesn't Exists", 10003);

	private String message;

	private int code;
	
	private Responses(String message, int code) {
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public int getCode() {
		return code;
	}
}

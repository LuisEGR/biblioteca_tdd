package main.common;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Generic Response Object.
 * 
 * @author "Jigar Gosalia"
 *
 */
@XmlRootElement(name = "response")
public class GenericResponse {

	private boolean status;

	private String message;

	private int errorCode;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public GenericResponse() {}

	public GenericResponse(boolean status, String message, int errorCode) {
		super();
		this.status = status;
		this.message = message;
		this.errorCode = errorCode;
	}

	public GenericResponse(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	@Override
	public String toString() {
		return status + "|" + message + "|" + errorCode;
	}
}
package main.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import main.constants.Constants;

/**
 * @author "Jigar Gosalia"
 *
 */
@XmlRootElement(name = "books")
public class Books {

	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Books() {}

	public Books(List<Book> employees) {
		super();
		this.books = (List<Book>) employees;
	}

	@Override
	public String toString() {
		StringBuilder data = new StringBuilder();
		for (Book book : books) {
			data.append(book).append(Constants.COMMA);
		}
		if (data.length() > 0) {
			data.deleteCharAt(data.length());
		}
		return data.toString();
	}
}
package main.pojo;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import main.common.Resource;

/**
 * @author "Jigar Gosalia"
 *
 */
@XmlRootElement(name = "book")
public class Book extends Resource {

	private static int count = 1000;

	private int id;

	private String name;

	private List<String> authors;

	private String isbn;

	private double price;

	private Date dateModified;

	public Book() {}

	public Book(String name, List<String> authors, String isbn, double price) {
		super();
		count++;
		this.id = count;
		this.name = name;
		this.authors = authors;
		this.isbn = isbn;
		this.price = price;
		this.dateModified = new Date();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", authors=" + authors
				+ ", isbn=" + isbn + ", price=" + price + "dateModified=" + dateModified + "]";
	}
}
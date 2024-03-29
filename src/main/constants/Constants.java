package main.constants;

import java.util.Arrays;

import main.pojo.Book;
import main.common.Link;
import main.common.Method;
import main.common.Relation;

/**
 * @author "Jigar Gosalia"
 * 
 */
public class Constants {

	public static final String COMMA = ",";

	public static final String NOSPACE = "";

	public static final String PATH_DELIMITER = "/";

	public static final int ZERO = 0;

	public static final Book dummyBook = new Book("Introduction to Algorithms", Arrays.asList("Thomas Cormen", "Charles Leiserson", "Ronald Rivest", "Clifford Stein"), "0262033844", 100);

	static {
		dummyBook.setLinks(Arrays.asList(new Link("/RESTJersey/library/book/dummy", Relation.SELF.getValue(), Method.GET.toString())));
	}
}
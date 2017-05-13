package service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import pojo.Book;
import pojo.Books;
import api.BookService;

import common.GenericResponse;
import common.Link;
import common.Method;
import common.Relation;
import common.Responses;

import constants.Constants;

/**
 * CRUD Operation Implementation of REST API.
 * 
 * @author "Jigar Gosalia"
 *
 */
@Path("/library")
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class BookServiceImpl implements BookService {

	@Context
	private UriInfo uri;

	private static Map<Integer, Book> books = new HashMap<Integer, Book>();

	private static Map<String, Book> booksByName = new HashMap<String, Book>();

	/* ---- Book API ---- */

	@Override
	@GET
	@Path("/book/{id}")
	public Response get(@PathParam("id") int id) {
		Book book = books.get(id);
		if (book != null) {
			return Response.ok(book).build();
		}
		return getResponse(Responses.DOESNT_EXISTS);
	}

	@Override
	@POST
	@Path("/book/")
	public Response add(Book book) {
		if (!booksByName.containsKey(book.getName())) {
			addBook(book);
			return getResponse(Responses.CREATED);
		}
		return getResponse(Responses.ALREADY_EXISTS);
	}

	@Override
	@PUT
	@Path("/book/")
	public Response edit(Book book) {
		if (booksByName.containsKey(book.getName())) {
			editBook(book);
			return getResponse(Responses.CREATED);
		}
		return getResponse(Responses.DOESNT_EXISTS);
	}

	@Override
	@DELETE
	@Path("/book/{id}")
	public Response delete(@PathParam("id") int id) {
		if (books.get(id) != null) {
			Book book = books.get(id);
			books.remove(id);
			booksByName.remove(book.getName());
			return getResponse(Responses.DELETED);
		}
		return getResponse(Responses.DOESNT_EXISTS);
	}

	@Override
	@GET
	@Path("/book/all")
	public Response getAll() {
		if (books.size() > 0) {
			List<Book> bookList = new LinkedList<>(books.values());
			return Response.ok(new Books(bookList)).build();
		}
		return getResponse(Responses.NO_DATA);
	}

	@GET
	@Path("/book/dummy")
	public Response getDummyBook() {
		return Response.ok(Constants.dummyBook).build();
	}

	private Response getResponse(Responses responseValue) {
		GenericResponse response = new GenericResponse();
		if (responseValue.equals(Responses.ALREADY_EXISTS)) {
			response = new GenericResponse(false, Responses.ALREADY_EXISTS.getMessage(), Responses.ALREADY_EXISTS.getCode());
			return Response.status(422).entity(response).build();
		} else if (responseValue.equals(Responses.CREATED)) {
			response = new GenericResponse(true, Responses.CREATED.getMessage());
			return Response.status(Response.Status.CREATED.getStatusCode()).entity(response).build();
		} else if (responseValue.equals(Responses.DOESNT_EXISTS)) {
			response = new GenericResponse(false, Responses.DOESNT_EXISTS.getMessage(), Responses.DOESNT_EXISTS.getCode());
			return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(response).build();
		} else if (responseValue.equals(Responses.DELETED)) {
			response = new GenericResponse(true, Responses.DELETED.getMessage());
			return Response.ok(response).build();
		} else if (responseValue.equals(Responses.NO_DATA)) {
			response = new GenericResponse(false, Responses.NO_DATA.getMessage(), Responses.NO_DATA.getCode());
			return Response.ok(response).build();
		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).build();
	}

	private void addBook(Book book) {
		Book newBook = new Book(book.getName(), book.getAuthors(), book.getIsbn(), book.getPrice());
		addLinks(newBook);
		books.put(newBook.getId(), newBook);
		booksByName.put(newBook.getName(), newBook);
	}

	private void editBook(Book book) {
		Book newBook = booksByName.get(book.getName());
		newBook.setAuthors(book.getAuthors());
		newBook.setIsbn(book.getIsbn());
		newBook.setPrice(book.getPrice());
		addLinks(newBook);
		books.put(newBook.getId(), newBook);
		booksByName.put(newBook.getName(), newBook);
	}

	private void addLinks(Book book) {
		String resourcePath = uri.getAbsolutePath().getPath() + Constants.PATH_DELIMITER + book.getId();
		Link getLink = new Link(resourcePath, Relation.SELF.getValue(), Method.GET.toString());
		Link deleteLink = new Link(resourcePath, Relation.SELF.getValue(), Method.DELETE.toString());
		Link putLink = new Link(resourcePath, Relation.SELF.getValue(), Method.PUT.toString());
		book.setLinks(Arrays.asList(getLink, deleteLink, putLink));
	}

}
package main.api;

import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import main.pojo.Book;

/**
 * CRUD Operations of REST API.
 * 
 * @author "Jigar Gosalia"
 * 
 */
public interface BookService {

	public Response add(Book book);

	public Response edit(Book book);

	public Response delete(int id);

	public Response get(int id, Request request);

	public Response getAll();
}
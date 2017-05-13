package application;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import service.BookServiceImpl;

/**
 * Library Application to host different resource service implementation.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class LibraryApplication extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();

	public LibraryApplication() {
		singletons.add(new BookServiceImpl());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
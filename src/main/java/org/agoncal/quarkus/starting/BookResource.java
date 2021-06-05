package org.agoncal.quarkus.starting;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces({MediaType.APPLICATION_JSON})
public class BookResource {

    private final BookRepository bookRepository;
    @Inject
    Logger logger;

    public BookResource(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GET
    public List<Book> getAllBooks() {
        logger.info("Returns all books");
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        logger.info("Count all books");
        return bookRepository.countAllBooks();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id) {
        logger.info("Return a book");
        return bookRepository.getBook(id);
    }
}
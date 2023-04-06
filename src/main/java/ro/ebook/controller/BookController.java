package ro.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ro.ebook.model.dto.BookDto;
import ro.ebook.service.BookService;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books") // endpoint
    public List<BookDto> listBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/{id}") // {bookId} este un "path variable"
    public BookDto getBookDetails(@PathVariable(value = "id") Integer bookId) {
        // create service method which receives the book id
        // the service method queries the database for a book with that id - using the repository object
        // map (transform) the retrieved entity into a dto and return the dto object back to the controller
        // the controller returns the dto back to the client (browser)
        return bookService.getById(bookId);
    }
}

// JSON - JavaScript Object Notation

// TODO
/*
Tema 1:
Create a new endpoint which retrieves the details of a book specified by id

GET /books/{bookId}
e.g. GET /books/2

Tema 2:
Create a new table authors. Map the table to an entity class Author.
Associate an author to a book -> the Book entity will have a new property (instance variable) of type Author.
The books table will have a new column called author_id (also create a foreign key constraint).

 */
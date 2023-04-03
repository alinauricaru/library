package ro.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}

// JSON - JavaScript Object Notation

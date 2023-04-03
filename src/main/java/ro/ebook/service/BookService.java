package ro.ebook.service;

import ro.ebook.model.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getBooks();
}

package ro.ebook.service;

import ro.ebook.model.dto.BookDto;

import java.util.List;

public interface BookService {

    //CRUD - create,read,update,delete

    //create
    Boolean createBook(BookDto dto);

    //read

    List<BookDto> getBooks();

    BookDto getById(Integer id);

    //update

    //delete


}

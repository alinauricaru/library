package ro.ebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ebook.model.dto.BookDto;
import ro.ebook.model.entity.Book;
import ro.ebook.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDto> getBooks() {
        // list of entity objects
        List<Book> books = bookRepository.findAll();
        // we map the list of entities
        // to a list of DTO objects
        List<BookDto> dtoList = books.stream()
                .map(bookEntity -> {
                    BookDto dto = new BookDto();
                    dto.setTitle(bookEntity.getTitle());
                    dto.setAuthor(bookEntity.getAuthor());
                    dto.setYear(bookEntity.getYear());
                    return dto;
                })
                .collect(Collectors.toList());
        return dtoList;
    }
}

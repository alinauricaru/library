package ro.ebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ebook.model.dto.BookDto;
import ro.ebook.model.entity.Book;
import ro.ebook.repository.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Boolean createBook(BookDto dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setYear(dto.getYear());
        Book databaseBook = bookRepository.save(book);
        return databaseBook != null;
    }

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

    @Override
    public BookDto getById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map((Book b) -> {
            BookDto dto = new BookDto();
            dto.setTitle(b.getTitle());
            dto.setAuthor(b.getAuthor());
            dto.setYear(b.getYear());
            return dto;
        }).orElse(new BookDto());
    }
}

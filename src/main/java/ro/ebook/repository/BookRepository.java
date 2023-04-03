package ro.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ebook.model.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}

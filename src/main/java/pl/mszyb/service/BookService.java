package pl.mszyb.service;

import pl.mszyb.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(long id);
    void addBook(Book book);
    Book editBook(Book book);
    void deleteBook(long id);
}

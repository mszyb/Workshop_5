package pl.mszyb.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import pl.mszyb.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MockBookService implements BookService {
    private List<Book> list;
    private static long nextId;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking in Java", "Bruce Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy,	Bates Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay	Horstmann, Gary Cornell", "Helion",
                "programming"));
        nextId = list.size() + 1;
    }

    @Override
    public List<Book> findAll() {
        return list;
    }

    @Override
    public Optional<Book> findById(long id) {
        return list
                .stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }

    @Override
    public void addBook(Book book) {
        book.setId(nextId);
        nextId++;
        list.add(book);
    }

    @Override
    public void editBook(Book newBook) {
        Book bookToEdit = list.stream()
                .filter(book -> book.getId().equals(newBook.getId()))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "book with this id not found"));
        list.remove(bookToEdit);
        list.add(newBook);
    }

    @Override
    public void deleteBook(long id) {
        list.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .ifPresent(book -> list.remove(book));
    }
}

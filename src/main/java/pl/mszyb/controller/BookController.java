package pl.mszyb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.mszyb.model.Book;
import pl.mszyb.service.MockBookService;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {
    private MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping(value = "/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping
    public List<Book> findAll() {
        return mockBookService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Book getBookById(@PathVariable long id) {
            return mockBookService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND ,"No book with such ID found"));
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        mockBookService.addBook(book);
    }

    @PutMapping
    public void editBook(@RequestBody Book book){
        mockBookService.editBook(book);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable long id){
        mockBookService.deleteBook(id);
    }
}

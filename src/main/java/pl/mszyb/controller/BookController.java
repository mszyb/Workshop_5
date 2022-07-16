package pl.mszyb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mszyb.model.Book;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @RequestMapping(value = "/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming");
    }
    
}

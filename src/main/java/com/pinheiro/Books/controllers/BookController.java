package com.pinheiro.Books.controllers;

import com.pinheiro.Books.domain.Book;
import com.pinheiro.Books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;
    @GetMapping("/load")
    public ResponseEntity<String> loadBooks() {
        try {
            service.saveBooksToDatabase();
            return ResponseEntity.ok("Books loaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error loading books: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        List<Book> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}

package com.pinheiro.Books.services;

import com.pinheiro.Books.domain.Book;
import com.pinheiro.Books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public List<Book> findAll(){
        return repository.findAll();
    }
}

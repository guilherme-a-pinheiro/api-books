package com.pinheiro.Books.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinheiro.Books.domain.Book;
import com.pinheiro.Books.dtos.BookRequestDTO;
import com.pinheiro.Books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<Book> getBooksFromJson() throws IOException {
        File file = new File("C:\\Users\\Guilherme\\Desktop\\estudos\\java\\Books\\src\\main\\resources\\static\\books-file.json");
        return objectMapper.readValue(file, new TypeReference<List<Book>>() {});
    }

    public void saveBooksToDatabase() throws IOException {
        List<Book> books = getBooksFromJson();
        repository.saveAll(books);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public void createBook(BookRequestDTO dto){
        Book newBook = new Book();
        newBook.setName(dto.name());
        newBook.setPublishedTime(dto.publishedTime());
        newBook.setAuthor(dto.author());
        newBook.setDescription(dto.description());
        newBook.setPrice(dto.price());
        repository.save(newBook);
    }
}

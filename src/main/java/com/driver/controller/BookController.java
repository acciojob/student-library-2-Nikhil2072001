package com.driver.controller;

import com.driver.models.Author;
import com.driver.models.Book;
import com.driver.models.Genre;
import com.driver.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Add required annotations
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    //Write createBook API with required annotations
    @PostMapping("/createBook")
    public ResponseEntity<String> createBook(@RequestBody Book book){
        bookService.createBook(book);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
    //Add required annotations
    @GetMapping("/getBooks")
    public ResponseEntity<List<Book>> getBooks(@RequestParam(value = "genre", required = false) String genre,
                                               @RequestParam(value = "available", required = false, defaultValue = "false") boolean available,
                                               @RequestParam(value = "author", required = false) String author){

        //find the elements of the list by yourself
        List<Book> bookList = bookService.getBooks(genre, available, author);
        return new ResponseEntity<>(bookList, HttpStatus.OK);

    }
}
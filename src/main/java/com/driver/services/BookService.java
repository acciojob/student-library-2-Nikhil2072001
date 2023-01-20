package com.driver.services;

import com.driver.models.Book;
import com.driver.models.Genre;
import com.driver.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository2;

    public void createBook(Book book){
        bookRepository2.save(book);
    }

    public List<Book> getBooks(String genre, boolean available, String author){

        if(genre == null && author == null)
            return bookRepository2.findByAvailability(available);

        if(genre == null)
            return bookRepository2.findBooksByAuthor(author, available);

        if(author == null)
            return bookRepository2.findBooksByGenre(genre, available);

        return bookRepository2.findBooksByGenreAuthor(genre, author, available);
    }
}
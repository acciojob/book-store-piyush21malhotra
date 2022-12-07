package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book newBook = bookService.createBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id){
        Book newBook = bookService.findBookById(id);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @GetMapping("/get-books-by-author")
    public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam String author){
        List<Book> newBook = bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @GetMapping("/get-books-by-genre")
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam String genre){
        List<Book> newBook = bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> newBook = bookService.findAllBooks();
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable String id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>("Book Deleted Successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-books")
    public ResponseEntity<String> deleteAllBook(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("All Books Deleted Successfully", HttpStatus.CREATED);
    }


}
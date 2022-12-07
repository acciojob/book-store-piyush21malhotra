package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private HashMap<Integer, Book> bookHashMap;
    private int id;
    public BookRepository(){
        this.id = 1;
        this.bookHashMap = new HashMap<>();
    }

    public Book save(Book book){
        book.setId(this.id);
        this.bookHashMap.put(book.getId(), book);
        this.id++;
        return book;
    }

    public Book findBookById(int id){
        return bookHashMap.get(id);
    }

    public List<Book> findAll(){

        return new ArrayList<>(bookHashMap.values());
    }

    public void deleteBookById(int id){
        bookHashMap.remove(id);
    }

    public void deleteAll(){
        bookHashMap.clear();
    }

    public List<Book> findBooksByAuthor(String author){

        List<Book> bookList = new ArrayList<>();
        for(Book book : bookHashMap.values()) {
            if(book.getAuthor().equals(author)) {
                bookList.add(book);
            }
        }
        return bookList;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> bookList = new ArrayList<>();
        for(Book book : bookHashMap.values()) {
            if(book.getGenre().equals(genre)) {
                bookList.add(book);
            }
        }
        return bookList;
    }
}

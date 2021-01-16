package com.designpatterns.dao.example1;

import java.util.ArrayList;
import java.util.List;

public class BooksImpl implements BooksDao {

    private List<Books> bookList;

    public BooksImpl() {
        bookList = new ArrayList<>();
        bookList.add(new Books("9780", "Alexandre Dumas", "The Three Musketeers"));
        bookList.add(new Books("9781", "Miguel de Cervantes", "Don Quixote"));
        bookList.add(new Books("9782", "A Study in Scarlet", "Arthur Conan Doyle"));
    }

    @Override
    public List<Books> getAllBooks() {
        return bookList;
    }

    @Override
    public Books getBooksByIsbn(int isbn) {
        return bookList.get(isbn);
    }

    @Override
    public void saveBook(Books book) {
        bookList.add(book);
    }

    @Override
    public void deleteBook(Books book){
        bookList.remove(book);
    }
}

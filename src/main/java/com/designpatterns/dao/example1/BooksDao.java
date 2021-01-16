package com.designpatterns.dao.example1;

import java.util.List;

public interface BooksDao {

    List<Books> getAllBooks();
    Books getBooksByIsbn(int isbn);
    void saveBook(Books books);
    void deleteBook(Books books);

}

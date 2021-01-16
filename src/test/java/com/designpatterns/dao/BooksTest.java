package com.designpatterns.dao;

import com.designpatterns.BaseTest;
import com.designpatterns.dao.example1.Books;
import com.designpatterns.dao.example1.BooksDao;
import com.designpatterns.dao.example1.BooksImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class BooksTest extends BaseTest {

    @Test
    public void testAllAuthors() {
        BooksDao booksDao = new BooksImpl();
        List<Books> booksList = booksDao.getAllBooks();
        AtomicInteger invalidAuthorsCount = new AtomicInteger();
        booksList.stream().forEach(book -> {
            if (book.getAuthor() == null || book.getIsbn().isEmpty()) {
                invalidAuthorsCount.incrementAndGet();
                log.error("ERROR: Author is null or empty for isbn: {}", book.getIsbn());
            }
        });

        if (invalidAuthorsCount.get() > 0) {
            Assert.fail();
        }
    }

    @Test
    public void testAllIsbn() {
        BooksDao booksDao = new BooksImpl();
        List<Books> booksList = booksDao.getAllBooks();
        AtomicInteger invalidIsbnCount = new AtomicInteger();
        booksList.stream().forEach(book -> {
            if (book.getIsbn() == null || book.getIsbn().isEmpty()) {
                invalidIsbnCount.incrementAndGet();
                log.error("ERROR: Isbn is null or empty for Author: {}", book.getAuthor());
            }
        });

        if (invalidIsbnCount.get() > 0) {
            Assert.fail();
        }
    }

    @Test
    public void testFirstBook() {
        BooksDao booksDao = new BooksImpl();
        Books book = booksDao.getAllBooks().get(0);
        soft.assertThat(book.getIsbn()).isEqualTo("9780");
        soft.assertThat(book.getAuthor()).isEqualTo("Alexandre Dumas");
        soft.assertThat(book.getBookName()).isEqualTo("The Three Musketeers");
    }

    @Test
    public void testSaveBooks() {
        BooksDao booksDao = new BooksImpl();
        booksDao.saveBook(new Books("1234", "Jane Austen", "Persuasion"));
        booksDao.saveBook(new Books("1245", "F. Scott Fitzgerald", "The Great Gatsby"));
        List<Books> booksList = booksDao.getAllBooks();
        Assert.assertEquals(booksList.size(), 5);
    }

    @Test
    public void testDeleteBooks() {
        BooksDao booksDao = new BooksImpl();
        booksDao.deleteBook(new Books("9782", "A Study in Scarlet", "Arthur Conan Doyle"));
        List<Books> booksList = booksDao.getAllBooks();
        Assert.assertEquals(booksList.size(), 2);
    }
}

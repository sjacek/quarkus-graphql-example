package com.github.sjacek.graphql.service;

import com.github.sjacek.graphql.dto.Book;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class BookService {

    public List<Book> getBooks() {
        return Book.books;
    }

    public Book getById(String id) {
        return Book.books.stream()
                .filter(book -> book.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Book> getBooksByAuthorId(String authorId) {
        return Book.books.stream()
                .filter(book -> book.authorId().equals(authorId))
                .toList();
    }

    public Book addBook(String title, int pageCount, String authorId) {
        Book book = Book.builder()
                .title(title)
                .pageCount(pageCount)
                .authorId(authorId)
                .build();
        Book.books.add(book);
        // In a real application, you would save the book to a database here
        return book;
    }
}

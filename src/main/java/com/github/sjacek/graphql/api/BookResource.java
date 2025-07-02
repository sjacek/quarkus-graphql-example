package com.github.sjacek.graphql.api;

import com.github.sjacek.graphql.dto.Author;
import com.github.sjacek.graphql.dto.Book;
import com.github.sjacek.graphql.dto.BookInput;
import com.github.sjacek.graphql.service.AuthorService;
import com.github.sjacek.graphql.service.BookService;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

import java.util.List;

@GraphQLApi
public class BookResource {

    final BookService bookService;
    final AuthorService authorService;

    private BookResource(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Query
    @Description("Get all books")
    public List<Book> getBooks() {
        return this.bookService.getBooks();
    }

    @Query
    @Description("Get book by id")
    public Book getBookById(@Name("id") String id) {
        Book book = this.bookService.getById(id);
        if (book == null) {
            throw new IllegalArgumentException("Book with id " + id + " not found");
        }
        return book;
    }

//    @Mutation
//    @Description("Add a new book")
//    public Book addBook(@Name("title") String title, @Name("pageCount") int pageCount, @Name("authorId") String authorId) {
//        Author author = this.authorService.getById(authorId);
//        if (author == null) {
//            throw new IllegalArgumentException("Author with id " + authorId + " not found");
//        }
//        return this.bookService.addBook(title, pageCount, authorId);
//    }

    @Mutation
    @Description("Add a new book")
    public Book addBook(BookInput input) {
        Author author = this.authorService.getById(input.getAuthorId());
        if (author == null) {
            throw new IllegalArgumentException("Author with id " + input.getAuthorId() + " not found");
        }
        return this.bookService.addBook(input.getTitle(), input.getPageCount(), input.getAuthorId());
    }


    public Author author(@Source Book book) {
        return this.authorService.getById(book.authorId());
    }
}

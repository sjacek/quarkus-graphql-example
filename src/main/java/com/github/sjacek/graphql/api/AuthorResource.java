package com.github.sjacek.graphql.api;

import com.github.sjacek.graphql.dto.Author;
import com.github.sjacek.graphql.service.AuthorService;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class AuthorResource {

    final AuthorService authorService;

    private AuthorResource(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Query
    @Description("Get all authors")
    public List<Author> getAuthors() {
        return this.authorService.getAuthors();
    }

    @Query
    @Description("Get author by id")
    public Author getAuthorById(String id) {
        Author author = this.authorService.getById(id);
        if (author == null) {
            throw new IllegalArgumentException("Author with id " + id + " not found");
        }
        return author;
    }
}

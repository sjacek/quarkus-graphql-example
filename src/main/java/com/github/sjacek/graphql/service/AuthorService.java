package com.github.sjacek.graphql.service;

import com.github.sjacek.graphql.dto.Author;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AuthorService {

    public List<Author> getAuthors() {
        return Author.authors;
    }

    public Author getById(String id) {
        return Author.authors.stream()
                .filter(author -> author.id().equals(id))
                .findFirst()
                .orElse(null);
    }

}

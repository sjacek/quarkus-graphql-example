package com.github.sjacek.graphql.service;

import com.github.sjacek.graphql.dto.Author;
import com.github.sjacek.graphql.dto.Book;
import com.github.sjacek.graphql.dto.SearchResult;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class SearchService {

    public List<SearchResult> search(String query) {
        List<SearchResult> results = new ArrayList<>();
        if (query == null || query.isBlank()) {
            return results;
        }
        String finalQuery = query.toLowerCase();
        results.addAll(
                Author.authors.stream()
                        .filter(author -> author.firstName().toLowerCase().contains(finalQuery)
                                || author.lastName().toLowerCase().contains(finalQuery))
                        .toList()
        );
        results.addAll(
                Book.books.stream()
                        .filter(book -> book.title().toLowerCase().contains(finalQuery))
                        .toList()
        );
        return results;
    }
}

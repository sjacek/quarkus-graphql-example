package com.github.sjacek.graphql.dto;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public record Author(
        String id,
        String firstName,
        String lastName
) {

    @Getter
    public static final List<Author> authors = Arrays.asList(
            new Author("author-1", "Joshua", "Bloch"),
            new Author("author-2", "Douglas", "Adams"),
            new Author("author-3", "Bill", "Bryson")
    );
}
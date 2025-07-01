package com.github.sjacek.graphql.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Builder
public record Book(
        String id,
        String title,
        int pageCount,
        String authorId
) {

    @Getter
    public static final List<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book("book-1", "Effective Java", 416, "author-1"),
            new Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, "author-2"),
            new Book("book-3", "Down Under", 436, "author-3"),
            new Book("book-4", "Java Concurrency in Practice", 384, "author-1"),
            new Book("book-5", "The Hitchhiker's Guide to the Galaxy: The Trilogy of Five", 800, "author-2"),
            new Book("book-6", "A Short History of Nearly Everything", 544, "author-3"),
            new Book("book-7", "Java: The Complete Reference", 1248, "author-1"),
            new Book("book-8", "So Long, and Thanks for All the Fish", 224, "author-2"),
            new Book("book-9", "The Lost Continent: Travels in Small-Town America", 304, "author-3"),
            new Book("book-10", "Java Performance: The Definitive Guide", 432, "author-1"),
            new Book("book-11", "The Restaurant at the End of the Universe", 224, "author-2"),
            new Book("book-12", "A Walk in the Woods: Rediscovering America on the Appalachian Trail", 304, "author-3"),
            new Book("book-13", "Java: A Beginner's Guide", 624, "author-1"),
            new Book("book-14", "Life, the Universe and Everything", 224, "author-2"),
            new Book("book-15", "Notes from a Small Island", 272, "author-3"),
            new Book("book-16", "Java in a Nutshell", 704, "author-1"),
            new Book("book-17", "Mostly Harmless", 288, "author-2"),
            new Book("book-18", "The Mother Tongue: English and How It Got That Way", 272, "author-3"),
            new Book("book-19", "Java: The Complete Reference, Eleventh Edition", 1248, "author-1"),
            new Book("book-20", "The Salmon of Doubt: Hitchhiking the Galaxy One Last Time", 272, "author-2"),
            new Book("book-21", "I'm a Stranger Here Myself: Notes on Returning to America After Twenty Years Away", 272, "author-3"),
            new Book("book-22", "Java: The Complete Reference, Twelfth Edition", 1248, "author-1"),
            new Book("book-23", "The Hitchhiker's Guide to the Galaxy: The Complete Radio Series", 320, "author-2"),
            new Book("book-24", "The Road to Little Dribbling: Adventures of an American in Britain", 304, "author-3"),
            new Book("book-25", "Java: The Complete Reference, Thirteenth Edition", 1248, "author-1"),
            new Book("book-26", "The Hitchhiker's Guide to the Galaxy: The Original Radio Scripts", 320, "author-2"),
            new Book("book-27", "The Life and Times of the Thunderbolt Kid: A Memoir", 304, "author-3"),
            new Book("book-28", "Java: The Complete Reference, Fourteenth Edition", 1248, "author-1"),
            new Book("book-29", "The Hitchhiker's Guide to the Galaxy: The Illustrated Edition", 320, "author-2"),
            new Book("book-30", "The Lost Continent: Travels in Small-Town America: A Memoir", 304, "author-3"),
            new Book("book-31", "Java: The Complete Reference, Fifteenth Edition", 1248, "author-1"),
            new Book("book-32", "The Hitchhiker's Guide to the Galaxy: The Complete Collection", 320, "author-2"),
            new Book("book-33", "A Short History of Nearly Everything: Special Illustrated Edition", 544, "author-3"),
            new Book("book-34", "Java: The Complete Reference, Sixteenth Edition", 1248, "author-1"),
            new Book("book-35", "The Hitchhiker's Guide to the Galaxy: The Complete Collection: The Illustrated Edition", 320, "author-2"),
            new Book("book-36", "A Walk in the Woods: Rediscovering America on the Appalachian Trail: Special Illustrated Edition", 304, "author-3")
    ));

    public static String nextId() {
        return "book-" + (books.size() + 1);
    }
}

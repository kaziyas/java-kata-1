package org.echocat.kata.java.part1.model;

/**
 * @author yaser.kazerooni (yaser.kazerooni@gmail.com)
 * @created 22/March/2022
 * @project java-kata-1
 */
public final class Book {

    private final String title;
    private final String isbn;
    private final String authors;
    private final String description;

    public Book(String title, String isbn, String authors, String description) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthors() {
        return authors;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors='" + authors + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

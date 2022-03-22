package org.echocat.kata.java.part1.model;

/**
 * @author yaser.kazerooni (yaser.kazerooni@gmail.com)
 * @created 22/March/2022
 * @project java-kata-1
 */
public final class Magazine {

    private final String title;
    private final String isbn;
    private final String authors;
    private final String publishedAt;

    public Magazine(String title, String isbn, String authors, String publishedAt) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
        this.publishedAt = publishedAt;
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

    public String getPublishedAt() {
        return publishedAt;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors='" + authors + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                '}';
    }
}

package org.echocat.kata.java.part1.service.impl;

import com.google.common.collect.ImmutableList;
import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.service.DataReader;
import org.echocat.kata.java.part1.service.DataWriter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yaser.kazerooni (yaser.kazerooni@gmail.com)
 * @created 23/March/2022
 * @project java-kata-1
 */
public class BookService implements DataReader<Book>, DataWriter {
    private static final String BOOKS_FILE_NAME = "books.csv";

    private final List<Book> books;
    private final List<String> header;

    public BookService() throws IOException, URISyntaxException {
        this.books = readData(readFileFromResources(BOOKS_FILE_NAME));
        this.header = readHeader(readFileFromResources(BOOKS_FILE_NAME));
    }

    @Override
    public ImmutableList<Book> readData(Stream<String> lines) {
        final List<Book> books =
                lines
                        .skip(1)
                        .map(s -> s.split(DELIMITER))
                        .map(str -> new Book(str[0], str[1], str[2], str[3]))
                        .collect(Collectors.toList());
        return ImmutableList.copyOf(books);
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void printData() {
        printHeader(header);
        books.forEach(
                book -> {
                    StringJoiner data = new StringJoiner(" | ");
                    data.add(book.getTitle());
                    data.add(book.getIsbn());
                    data.add(book.getAuthors());
                    data.add(book.getDescription());
                    System.out.println(data.toString());
                });
    }

    public void findAndPrintAllBookByEmail(Set<String> emails) {
        emails.forEach(
                email -> {
                    System.out.println("\nFind books by author's email:" + email);
                    books.stream()
                            .filter(book -> book.getAuthors().contains(email))
                            .forEach(System.out::println);
                    System.out.println("*********************");
                });
    }

    public Book findAndPrintBookByIsbn(String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().get();
    }
}

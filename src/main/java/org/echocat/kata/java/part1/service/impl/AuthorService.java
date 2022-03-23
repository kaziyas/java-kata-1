package org.echocat.kata.java.part1.service.impl;

import com.google.common.collect.ImmutableList;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.service.DataReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yaser.kazerooni (yaser.kazerooni@gmail.com)
 * @created 23/March/2022
 * @project java-kata-1
 */
public class AuthorService implements DataReader<Author> {
    private static final String AUTHORS_FILE_NAME = "authors.csv";

    private final List<Author> authors;

    public AuthorService() throws IOException, URISyntaxException {
        this.authors = readData(readFileFromResources(AUTHORS_FILE_NAME));
    }

    public ImmutableList<Author> readData(Stream<String> lines) {
        final List<Author> authors =
                lines
                        .skip(1)
                        .map(s -> s.split(DELIMITER))
                        .map(str -> new Author(str[1], str[2], str[0]))
                        .collect(Collectors.toList());
        return ImmutableList.copyOf(authors);
    }

    public Set<String> getAuthorsEmail() {
        return authors.stream()
                .map(Author::getEmail).collect(Collectors.toSet());
    }
}

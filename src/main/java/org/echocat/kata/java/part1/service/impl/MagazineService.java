package org.echocat.kata.java.part1.service.impl;

import com.google.common.collect.ImmutableList;
import org.echocat.kata.java.part1.model.Magazine;
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
public class MagazineService implements DataReader<Magazine>, DataWriter {
    private static final String MAGAZINE_FILE_NAME = "magazines.csv";

    private final List<String> header;
    private final List<Magazine> magazines;

    public MagazineService() throws IOException, URISyntaxException {
        this.header = readHeader(readFileFromResources(MAGAZINE_FILE_NAME));
        this.magazines = readData(readFileFromResources(MAGAZINE_FILE_NAME));
    }

    @Override
    public ImmutableList<Magazine> readData(Stream<String> lines) {
        final List<Magazine> Magazines =
                lines
                        .skip(1)
                        .map(s -> s.split(DELIMITER))
                        .map(str -> new Magazine(str[0], str[1], str[2], str[3]))
                        .collect(Collectors.toList());
        return ImmutableList.copyOf(Magazines);
    }

    public List<Magazine> getMagazines() {
        return magazines;
    }

    @Override
    public void printData() {
        printHeader(header);
        magazines.forEach(
                magazine -> {
                    StringJoiner data = new StringJoiner(" | ");
                    data.add(magazine.getTitle());
                    data.add(magazine.getIsbn());
                    data.add(magazine.getAuthors());
                    data.add(magazine.getPublishedAt());
                    System.out.println(data.toString());
                });
    }

    public void findAndPrintAllMagazineByEmail(Set<String> emails) {
        emails.forEach(
                email -> {
                    System.out.println("\nFind magazines by author's email:" + email);
                    magazines.stream()
                            .filter(magazine -> magazine.getAuthors().contains(email))
                            .forEach(System.out::println);
                    System.out.println("*********************");
                });
    }
}

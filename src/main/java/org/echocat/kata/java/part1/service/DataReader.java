package org.echocat.kata.java.part1.service;

import com.google.common.collect.ImmutableList;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Magazine;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author yaser.kazerooni (yaser.kazerooni@gmail.com)
 * @created 23/March/2022
 * @project java-kata-1
 */
public interface DataReader<T> {
    String DELIMITER = ";";
    String PACKAGE_URL_PATH = "org/echocat/kata/java/part1/data";

    default ImmutableList<String> readHeader(Stream<String> lines) {
        final List<String> header =
                lines.findFirst().map((line) -> Arrays.asList(line.split(DELIMITER))).orElseThrow();
        return ImmutableList.copyOf(header);
    }

    default Stream<String> readFileFromResources(String fileName)
            throws IOException, URISyntaxException {
        final URI uri = ClassLoader.getSystemResource(PACKAGE_URL_PATH).toURI();
        final String mainPath = Paths.get(uri).toString();
        final Path path = Paths.get(mainPath, fileName);
        return Files.lines(path);
    }

    ImmutableList<T> readData(Stream<String> lines);
}

package org.echocat.kata.java.part1.service;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author yaser.kazerooni (yaser.kazerooni@gmail.com)
 * @created 24/March/2022
 * @project java-kata-1
 */
public interface DataWriter {

    default void printHeader(List<String> header) {
        StringJoiner title = new StringJoiner(" | ");
        StringJoiner line = new StringJoiner(" + ");
        header.forEach(
                s -> {
                    title.add(s.toUpperCase());
                    line.add("--------------");
                });
        System.out.println(title);
        System.out.println(line);
    }

    void printData();
}

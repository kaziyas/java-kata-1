package org.echocat.kata.java.part1.model;

/**
 * @author yaser.kazerooni (yaser.kazerooni@gmail.com)
 * @created 22/March/2022
 * @project java-kata-1
 */
public final class Author {

    private final String name;
    private final String family;
    private final String email;

    public Author(String name, String family, String email) {
        this.name = name;
        this.family = family;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;
import org.echocat.kata.java.part1.service.impl.AuthorService;
import org.echocat.kata.java.part1.service.impl.BookService;
import org.echocat.kata.java.part1.service.impl.MagazineService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yaser.kazerooni (yaser.kazerooni@gmail.com)
 * @created 4/April/2022
 * @project java-kata-1
 */
public class MainApp {

    public static void main(String[] args) {
        try {
            BookService bookService = new BookService();
            System.out.println("\n" + "-------------------------------------------------------------");
            bookService.printData();
            Book book = bookService.findAndPrintBookByIsbn("4545-8558-3232");
            System.out.println("\nThe search result for isbn 4545-8558-3232 "  + book.toString());
            bookService.findAndPrintAllBookByEmail(new AuthorService().getAuthorsEmail());
            System.out.println("\n" + "-------------------------------------------------------------");
            MagazineService magazineService = new MagazineService();
            magazineService.printData();
            magazineService.findAndPrintAllMagazineByEmail(new AuthorService().getAuthorsEmail());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

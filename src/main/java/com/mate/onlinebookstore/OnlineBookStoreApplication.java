package com.mate.onlinebookstore;

import com.mate.onlinebookstore.model.Book;
import com.mate.onlinebookstore.service.BookService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineBookStoreApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(OnlineBookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Book book = new Book();
            book.setAuthor("Yurii");
            book.setIsbn("isbn");
            book.setPrice(new BigDecimal(1000));
            book.setTitle("Harry");
            book.setDescription("magic");
            book.setCoverImage("glasses");
            bookService.save(book);
            System.out.println(bookService.findAll());
        };
    }
}

package com.mate.onlinebookstore.repository;

import com.mate.onlinebookstore.model.Book;
import java.util.List;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}

package com.mate.onlinebookstore.service;

import com.mate.onlinebookstore.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    List findAll();
}

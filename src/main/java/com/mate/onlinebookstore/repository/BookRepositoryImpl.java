package com.mate.onlinebookstore.repository;

import com.mate.onlinebookstore.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Book save(Book book) {
        try {
            entityManager.persist(book);
            return book;
        } catch (PersistenceException e) {
            throw new RuntimeException("failed to save Book", e);
        }
    }

    @Override
    public List<Book> findAll() {
        try {
            return entityManager
                    .createQuery("SELECT b FROM Book b", Book.class)
                    .getResultList();
        } catch (PersistenceException e) {
            throw new RuntimeException("failed to get lis of books", e);
        }
    }

    @Override
    public Optional<Book> findById(Long id) {
        try {
            Book book = entityManager.find(Book.class, id);
            return Optional.ofNullable(book);
        } catch (PersistenceException e) {
            throw new RuntimeException("failed to get book with id " + id, e);
        }
    }
}

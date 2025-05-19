package com.mate.onlinebookstore.service;

import com.mate.onlinebookstore.dto.BookDto;
import com.mate.onlinebookstore.dto.CreateBookRequestDto;
import com.mate.onlinebookstore.exception.EntityNotFoundException;
import com.mate.onlinebookstore.mapper.BookMapper;
import com.mate.onlinebookstore.model.Book;
import com.mate.onlinebookstore.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookRepository.save(bookMapper.toModel(requestDto));
        return bookMapper.toDto(book);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository
                .findAll()
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No such book with id " + id));

        return bookMapper.toDto(book);
    }
}

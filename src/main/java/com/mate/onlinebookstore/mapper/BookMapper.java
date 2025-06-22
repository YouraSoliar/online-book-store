package com.mate.onlinebookstore.mapper;

import com.mate.onlinebookstore.config.MapperConfig;
import com.mate.onlinebookstore.dto.BookDto;
import com.mate.onlinebookstore.dto.CreateBookRequestDto;
import com.mate.onlinebookstore.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto requestDto);

    void updateBookFromDto(CreateBookRequestDto book, @MappingTarget Book entity);
}

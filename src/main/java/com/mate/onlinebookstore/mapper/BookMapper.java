package com.mate.onlinebookstore.mapper;

import com.mate.onlinebookstore.config.MapperConfig;
import com.mate.onlinebookstore.dto.BookDto;
import com.mate.onlinebookstore.dto.CreateBookRequestDto;
import com.mate.onlinebookstore.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto (Book book);

    Book toModel (CreateBookRequestDto requestDto);
}

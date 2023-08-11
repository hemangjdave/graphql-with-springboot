package com.techrevolution.graphql.graphqlwithspringboot.service;

import com.techrevolution.graphql.graphqlwithspringboot.dtos.BookDto;
import com.techrevolution.graphql.graphqlwithspringboot.entity.BookEntity;
import com.techrevolution.graphql.graphqlwithspringboot.exceptions.NoRecordFoundException;
import com.techrevolution.graphql.graphqlwithspringboot.mappers.BookMapper;
import com.techrevolution.graphql.graphqlwithspringboot.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private static final BookMapper INSTANCE = BookMapper.INSTANCE;

    public BookDto createBook(BookDto bookDto) {
        BookEntity bookEntity = INSTANCE.getBookEntity(bookDto);
        BookEntity entity = bookRepository.save(bookEntity);
        return INSTANCE.getBookDtoFromEntity(entity);
    }

    public List<BookDto> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return INSTANCE.getAllBooksFromEntity(bookEntities);
    }

    public BookDto getBookById(Long bookId) {
        Optional<BookEntity> book = bookRepository.findById(bookId);
        BookEntity bookEntity = book.orElseThrow(() ->
                NoRecordFoundException.builder()
                        .errorCode("404")
                        .errorMessage("No book found with given id")
                        .build());
        return INSTANCE.getBookDtoFromEntity(bookEntity);
    }
}

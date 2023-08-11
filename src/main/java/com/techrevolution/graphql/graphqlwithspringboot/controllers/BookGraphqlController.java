package com.techrevolution.graphql.graphqlwithspringboot.controllers;

import com.techrevolution.graphql.graphqlwithspringboot.dtos.BookDto;
import com.techrevolution.graphql.graphqlwithspringboot.mappers.BookMapper;
import com.techrevolution.graphql.graphqlwithspringboot.requestmodels.BookRequestModel;
import com.techrevolution.graphql.graphqlwithspringboot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookGraphqlController {

    private final BookService bookService;

    private static final BookMapper INSTANCE = BookMapper.INSTANCE;

    @MutationMapping("createBook")
    public BookRequestModel createBook(@Argument BookRequestModel bookRequestModel) {
        BookDto bookDto = INSTANCE.getBookDto(bookRequestModel);
        BookDto book = bookService.createBook(bookDto);
        return INSTANCE.getBookRequestModel(book);
    }


    @QueryMapping("getAllBooks")
    public List<BookRequestModel> getAllBooks() {
        List<BookDto> allBooks = bookService.getAllBooks();
        return INSTANCE.getAllBooksRequestModel(allBooks);
    }

    @QueryMapping("getBookById")
    public BookRequestModel getBookById(@Argument Long bookId) {
        BookDto bookDto = bookService.getBookById(bookId);
        return INSTANCE.getBookRequestModel(bookDto);
    }
}

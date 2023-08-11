package com.techrevolution.graphql.graphqlwithspringboot.controllers;

import com.techrevolution.graphql.graphqlwithspringboot.dtos.BookDto;
import com.techrevolution.graphql.graphqlwithspringboot.mappers.BookMapper;
import com.techrevolution.graphql.graphqlwithspringboot.requestmodels.BookRequestModel;
import com.techrevolution.graphql.graphqlwithspringboot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    private static final BookMapper INSTANCE = BookMapper.INSTANCE;

    @PostMapping("/book")
    public ResponseEntity<BookRequestModel> createBook(@RequestBody BookRequestModel bookRequestModel) {
        BookDto bookDto = INSTANCE.getBookDto(bookRequestModel);
        BookDto book = bookService.createBook(bookDto);
        return ResponseEntity.ok(
                INSTANCE.getBookRequestModel(book)
        );
    }

    @GetMapping("/all-books")
    public ResponseEntity<List<BookRequestModel>> getAllBooks() {
        List<BookDto> allBooks = bookService.getAllBooks();
        return ResponseEntity.ok(
                INSTANCE.getAllBooksRequestModel(allBooks)
        );
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<BookRequestModel> getBookById(@PathVariable Long bookId) {
        BookDto bookDto = bookService.getBookById(bookId);
        return ResponseEntity.ok(
                INSTANCE.getBookRequestModel(bookDto)
        );
    }
}

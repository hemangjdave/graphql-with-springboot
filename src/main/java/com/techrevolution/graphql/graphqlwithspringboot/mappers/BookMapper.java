package com.techrevolution.graphql.graphqlwithspringboot.mappers;

import com.techrevolution.graphql.graphqlwithspringboot.dtos.BookDto;
import com.techrevolution.graphql.graphqlwithspringboot.entity.BookEntity;
import com.techrevolution.graphql.graphqlwithspringboot.requestmodels.BookRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto getBookDto(BookRequestModel bookRequestModel);

    BookEntity getBookEntity(BookDto bookDto);

    BookRequestModel getBookRequestModel(BookDto bookDto);

    BookDto getBookDtoFromEntity(BookEntity bookEntity);

    List<BookDto> getAllBooksFromEntity(List<BookEntity> bookEntities);

    List<BookRequestModel> getAllBooksRequestModel(List<BookDto> bookDtos);
}

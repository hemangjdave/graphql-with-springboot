package com.techrevolution.graphql.graphqlwithspringboot.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BookDto {
    private Long id;
    private String name;
    private String description;
    private String author;
    private String title;
    private int pages;
}

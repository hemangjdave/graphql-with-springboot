package com.techrevolution.graphql.graphqlwithspringboot.repositories;

import com.techrevolution.graphql.graphqlwithspringboot.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}

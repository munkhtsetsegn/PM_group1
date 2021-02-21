package com.springframework.webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.springframework.webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

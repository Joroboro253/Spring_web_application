package com.ua.joroboro.repo;

import com.ua.joroboro.models.Note;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Note, Long> {
}

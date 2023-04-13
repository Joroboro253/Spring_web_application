package com.ua.joroboro.repo;

import com.ua.joroboro.models.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}

package com.codegym.inotes.service;

import com.codegym.inotes.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteService {
    void save(Note note);

    Page<Note> findAll(Pageable pageable);

    Note findById(Long id);

    void remove(Long id);
}

package com.codegym.inotes.service;

import com.codegym.inotes.model.Note;
import com.codegym.inotes.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteService {
    void save(Note note);

    Page<Note> findAll(Pageable pageable);

    Note findById(Long id);

    void remove(Long id);

    Page<Note> findAllByTitleContaining(String title, Pageable pageable);

    Page<Note> findAllByNoteType(NoteType noteType, Pageable pageable);

}

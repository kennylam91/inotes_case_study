package com.codegym.inotes.repository;

import com.codegym.inotes.model.Note;
import com.codegym.inotes.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Note,Long> {

    Page<Note> findAllByTitleContaining(String title, Pageable pageable);

    Page<Note> findAllByNoteType(NoteType noteType, Pageable pageable);
}

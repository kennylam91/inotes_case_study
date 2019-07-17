package com.codegym.inotes.service;

import com.codegym.inotes.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteTypeService {
    void save(NoteType noteType);

    Page<NoteType> findAll(Pageable pageable);

    NoteType findById(Long id);

    void remove(Long id);
}

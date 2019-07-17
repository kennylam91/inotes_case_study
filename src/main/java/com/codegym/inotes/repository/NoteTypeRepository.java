package com.codegym.inotes.repository;

import com.codegym.inotes.model.NoteType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteTypeRepository extends PagingAndSortingRepository<NoteType,Long> {
}

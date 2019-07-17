package com.codegym.inotes.controller;

import com.codegym.inotes.model.Note;
import com.codegym.inotes.model.NoteType;
import com.codegym.inotes.service.NoteService;
import com.codegym.inotes.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("/inotes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteTypeService noteTypeService;

//    @GetMapping
//    public ModelAndView list(@RequestParam("noteTypeId") Optional<Long> noteTypeId, @RequestParam("nameSearch") Optional<String> nameSearch,
//                             @RequestParam("sort") Optional<String> sort, @PageableDefault(size = 5, page = 0, sort = "name") Pageable pageable) {
//        Page<Note> notes;
//        if (sort.isPresent()) pageable.getSort().getOrderFor(sort.get());
//        if (nameSearch.isPresent()) {
//            notes = noteService.findAllByNameContaining(nameSearch.get(), pageable);
//        } else if (noteTypeId.isPresent()) {
//            NoteType noteType = noteTypeService.findById(noteTypeId.get());
//            notes = noteService.findAllByNoteType(noteType, pageable);
//        } else {
//            notes = noteService.findAll(pageable);
//        }
//        ModelAndView modelAndView = new ModelAndView("/note/list");
//        modelAndView.addObject("notes", notes);
//        return modelAndView;
//    }

    @GetMapping("/create")
    public ModelAndView getCreateForm(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/note/create");
        modelAndView.addObject("note", new Note());
        modelAndView.addObject("noteTypes", noteTypeService.findAll(pageable));
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("note") Note note, BindingResult bindingResult,
                               Pageable pageable, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/note/create");
            modelAndView.addObject("noteTypes", noteTypeService.findAll(pageable));
            return modelAndView;
        } else {
            noteService.save(note);
            ModelAndView modelAndView = new ModelAndView("redirect:/notes");
            return modelAndView;
        }
    }

//    @GetMapping("/delete/{id}")
//    public ModelAndView getDeleteForm(@PathVariable Long id) {
//        ModelAndView modelAndView = new ModelAndView("/note/delete");
//        modelAndView.addObject("note", noteService.findById(id));
//        return modelAndView;
//    }
//
//    @PostMapping("/delete")
//    public ModelAndView delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
//        noteService.remove(id);
//        ModelAndView modelAndView = new ModelAndView("redirect:/notes");
//        return modelAndView;
//    }
//
//    @GetMapping("/edit/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id, Pageable pageable) {
//        ModelAndView modelAndView = new ModelAndView("/note/edit");
//        Note note = noteService.findById(id);
//        modelAndView.addObject("note", note);
//        modelAndView.addObject("noteTypes", noteTypeService.findAll(pageable));
//        return modelAndView;
//    }
//
//    @PostMapping("/update")
//    public ModelAndView update(@Validated @ModelAttribute("note") Note note, BindingResult bindingResult,
//                               RedirectAttributes redirectAttributes, Pageable pageable) {
//        if (bindingResult.hasFieldErrors()) {
//            ModelAndView modelAndView = new ModelAndView("/note/edit");
//            modelAndView.addObject("noteTypes", noteTypeService.findAll(pageable));
//            return modelAndView;
//        } else {
//            noteService.save(note);
//            ModelAndView modelAndView = new ModelAndView("redirect:/notes");
//            return modelAndView;
//        }
//
//    }
//
//
//    @GetMapping("/view/{id}")
//    public ModelAndView getViewForm(@PathVariable("id") Long id) {
//        ModelAndView modelAndView = new ModelAndView("/note/view");
//        modelAndView.addObject("note", noteService.findById(id));
//        return modelAndView;
//    }


}

package com.ua.joroboro.controllers;

import com.ua.joroboro.models.Note;
import com.ua.joroboro.repo.NoteRepository;
import jakarta.persistence.PostRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@Controller
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    //все заметки
    @GetMapping("/note")
    public String noteMain(Model model){
        Iterable<Note> notes = noteRepository.findAll(); // массив данных со всеми значениями из Бд
        model.addAttribute("notes", notes);
        return "note-main";
    }

    @GetMapping("/note/add")
    public String noteAdd(Model model){
        return "note-add";
    }

    @PostMapping("/note/add") //??
    public String notePostAdd(@RequestParam String title, @RequestParam String content, Model model) {
        Note note = new Note(title, content);
        noteRepository.save(note);
        return "redirect:/note";
    }


    @GetMapping("/note/{id}")
    public String noteDetails(@PathVariable(value = "id") long id, Model model) {
        if(!noteRepository.existsById(id)) {
            return "redirect:/note";
        }

        Optional<Note> note = noteRepository.findById(id);
        ArrayList<Note> res = new ArrayList<>();
        note.ifPresent(res::add);
        model.addAttribute("note", res);
        return "note-details";
    }

    @GetMapping("/note/{id}/edit")
    public String noteEdit(@PathVariable(value = "id") long id, Model model){
        if(!noteRepository.existsById(id)) {
            return "redirect:/note";
        }
        Optional<Note> note = noteRepository.findById(id);
        ArrayList<Note> res = new ArrayList<>();
        note.ifPresent(res::add);
        model.addAttribute("note", res);
        return "note-edit";

    }

    @PostMapping("/note/{id}/edit")
    public String blockNoteUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String content, Model model){
        Note note = noteRepository.findById(id).orElseThrow();
        note.setTitle(title);
        note.setContent(content);
        noteRepository.save(note);

        return "redirect:/note";
    }


    @PostMapping("/note/{id}/remove")
    public String blockNoteDelete(@PathVariable(value = "id") long id, Model model) {
        Note note = noteRepository.findById(id).orElseThrow();
        noteRepository.delete(note);

        return "redirect:/note";
    }


}

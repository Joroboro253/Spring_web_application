package com.ua.joroboro.controllers;

import com.ua.joroboro.models.Note;
import com.ua.joroboro.repo.PostRepository;
import jakarta.persistence.PostRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class NoteController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/note/add")
    public String noteAdd(Model model){
        return "note-add";
    }

//    реализую чуть позже
    //    @GetMapping("/note/getAll")
//    public String getAll(Model model){
//        return "";
//    }

    @GetMapping("/note/{id}")
    public String noteDetails(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)) {
            return "redirect:/note";
        }

        Optional<Note> post = postRepository.findById(id);
        ArrayList<Note> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "note-details";
    }
}

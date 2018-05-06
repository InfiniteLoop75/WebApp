package uz.infiniteloop.WebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.infiniteloop.WebApp.repositories.AuthorRepository;

@Controller
public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @RequestMapping("/authors")
    public String getBooks(Model model){
        model.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }
}

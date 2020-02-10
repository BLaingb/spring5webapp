package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.model.repositories.AuthorRepository;

/**
 * AuthorController
 */
@Controller
public class AuthorController {

    private final AuthorRepository authorRepo;

    public AuthorController(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorRepo.findAll());
        return "authors/list";
    }
}
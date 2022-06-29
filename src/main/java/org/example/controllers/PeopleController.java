package org.example.controllers;


import org.example.dao.PersonsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private PersonsDAO personsDAO;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("people", personsDAO.getAllPersons());
        return "people/allPersons";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("currentPerson", personsDAO.getPerson(id));
        return "people/person";
    }
}

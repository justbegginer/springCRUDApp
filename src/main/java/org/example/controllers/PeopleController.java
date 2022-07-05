package org.example.controllers;


import org.example.dao.PersonsDAO;
import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/new")
    public String getNewPerson(Model model)
    {
        model.addAttribute("person", new Person());
        return "people/new";
    }
    @PostMapping
    public String createNewPerson(@ModelAttribute("person")  Person person){
        personsDAO.add(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personsDAO.getPerson(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person){
        personsDAO.update(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/delete")
    public String deletePerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personsDAO.getPerson(id));
        return "people/delete";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personsDAO.delete(id);
        return "redirect:/people";
    }
}

package org.example.controllers;


import org.example.dao.PersonsDAO;
import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getNewPerson(){
        return "people/new";
    }
    @PostMapping
    public String createNewPerson(@RequestParam("name") String name,
                                  @RequestParam("surname") String surname){
        personsDAO.add(new Person(name, surname));
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personsDAO.getPerson(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("person") Person person){
        personsDAO.update(person, id);
        return "redirect:/people";
    }
}

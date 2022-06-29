package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonsDAO {
    private List<Person> persons;
    {
        persons = new ArrayList<>();
        persons.add(new Person("john", "doe"));
        persons.add(new Person("ivan", "ivanov"));
        persons.add(new Person("Matthew", "McConaughey"));
    }
    public List<Person> getAllPersons(){
        return this.persons;
    }
    public Person getPerson(int id){
        return persons
                .stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

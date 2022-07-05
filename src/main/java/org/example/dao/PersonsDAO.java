package org.example.dao;

import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonsDAO {
    private static JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getAllPersons() {
        return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper());
    }

    public Person getPerson(int id) {
        return jdbcTemplate.query("SELECT * FROM Person " +
                "WHERE id = ?;", new Object[]{id},new PersonMapper())
                .stream()
                .findFirst()
                .orElse(null);
    }

    public void add(Person person) {
        jdbcTemplate.update("INSERT INTO person VALUES (default, ?, ?);",
                person.getFirstName(), person.getSecondName());
    }

    public void update(Person person, int id) {
        jdbcTemplate.update("UPDATE person " + "SET name = ?, surname = ? " + "WHERE id = ?;",
                person.getFirstName(), person.getSecondName(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person " + "WHERE id = ? ;", id);
    }
}

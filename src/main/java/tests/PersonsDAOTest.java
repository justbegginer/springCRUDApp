package tests;

import org.example.dao.PersonsDAO;
import org.example.models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class PersonsDAOTest {

    @Test
    void getAllPersons() {
        PersonsDAO personsDAO = new PersonsDAO();
        List<Person> personList = personsDAO.getAllPersons();
        for (Person person : personList) {
            System.out.println(person);
        }
    }

    @Test
    void getPerson() {
        PersonsDAO personsDAO = new PersonsDAO();
        System.out.println(personsDAO.getPerson(personsDAO.getCount()));
    }

    @Test
    void add() {
        PersonsDAO personsDAO = new PersonsDAO();
        personsDAO.add(new Person(1, "test", "add"));
        Person lastPerson = personsDAO.getPerson(personsDAO.getCount());
        Assertions.assertTrue(new Person(personsDAO.getCount(), "test", "add").equal(lastPerson));
    }

    @Test
    void update() {
        PersonsDAO personsDAO = new PersonsDAO();
        personsDAO.update(new Person(personsDAO.getCount(), "1", "1"), personsDAO.getCount());
        Assertions.assertTrue(new Person(personsDAO.getCount(), "1", "1")
                .equal(personsDAO.getPerson(personsDAO.getCount())));
    }

    @Test
    void delete() {
        PersonsDAO personsDAO = new PersonsDAO();
        int countBefore = personsDAO.getCount();
        List<Person> personListBefore = personsDAO.getAllPersons();
        personsDAO.delete(personsDAO.getCount());
        List<Person> personList = personsDAO.getAllPersons();
        Assertions.assertEquals(personsDAO.getCount() + 1, countBefore);
        for (int i = 0; i < personList.size(); i++) {
            Assertions.assertTrue(personList.get(i).equal(personListBefore.get(i)));
        }
    }
    @Test
    void getCount(){
        System.out.println(new PersonsDAO().getCount());
    }
}
package org.example.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;

    public Person(int id, String firstName, String secondName) {
        this.id = id;
        this.name = firstName;
        this.surname = secondName;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public void setSurname(String secondName) {
        this.surname = secondName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + name + '\'' +
                ", secondName='" + surname + '\'' +
                '}';
    }

    public boolean equal(Person anotherPerson) {
        return anotherPerson.getId() == this.getId() &&
                Objects.equals(anotherPerson.getName(), this.getName()) &&
                Objects.equals(anotherPerson.getSurname(), this.getSurname());
    }
}

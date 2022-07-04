package org.example.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;


public class Person {
    private int id;
    private String firstName;
    private String secondName;
    public Person(int id, String firstName, String secondName){
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Person(){}

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
    public boolean equal(Person anotherPerson){
        return  anotherPerson.getId() == this.getId() &&
                Objects.equals(anotherPerson.getFirstName(), this.getFirstName()) &&
                Objects.equals(anotherPerson.getSecondName(), this.getSecondName());
    }
}

package org.example.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


public class Person {
    private int id;
    private static int idCounter = 0;
    private String firstName;
    private String secondName;
    public Person(String firstName, String secondName){
        this.id = Person.idCounter;
        Person.idCounter++;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Person(){}

    public int getId() {
        return id;
    }

    public static int getIdCounter() {
        return idCounter;
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
}

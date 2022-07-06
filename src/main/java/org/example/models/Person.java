package org.example.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;

    public boolean equal(Person anotherPerson) {
        return anotherPerson.getId() == this.getId() &&
                Objects.equals(anotherPerson.getName(), this.getName()) &&
                Objects.equals(anotherPerson.getSurname(), this.getSurname());
    }
}

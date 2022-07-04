package org.example.dao;

import org.example.Property;
import org.example.models.Person;
import org.springframework.aop.scope.ScopedObject;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonsDAO {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(Property.URL, Property.User, Property.Password);
            // Property is a class of static fields in what contains sources of DB
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(connection != null);
    }

    public List<Person> getAllPersons() {
        List<Person> resultList = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setFirstName(resultSet.getString("name"));
                person.setSecondName(resultSet.getString("surname"));
                resultList.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public Person getPerson(int id) {
        Statement statement = null;
        Person person = new Person();
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM Person " +
                    "WHERE id =" + id + ";";
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            person.setFirstName(resultSet.getString("name"));
            person.setSecondName(resultSet.getString("surname"));
            person.setId(resultSet.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    public void add(Person person) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO person VALUES (default, '" + person.getFirstName() + "', '" + person.getSecondName() + "');";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Person person, int id) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "UPDATE person "+
                    "SET name = '"+person.getFirstName()+"', surname = '"+person.getSecondName()+"' " +
                    "WHERE id ="+id+";";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "DELETE FROM person "+
                    "WHERE id = "+id+" ;";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getCount() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(query);
            int result = 0;
            for (; resultSet.next(); result++) {
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }
}

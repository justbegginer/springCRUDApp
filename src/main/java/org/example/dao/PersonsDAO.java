package org.example.dao;

import org.example.models.HibernateSessionFactory;
import org.example.models.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonsDAO {
    public List<Person> getAllPersons() {
        return HibernateSessionFactory.getSessionFactory().openSession().createQuery("From Person").list();
    }

    public Person getPerson(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Person.class, id);
    }

    public void add(Person person) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }

    public void update(Person person) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(person);
        transaction.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(getPerson(id));
        transaction.commit();
        session.close();
    }
}

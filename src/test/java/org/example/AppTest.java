package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AppTest {

    private SessionFactory sessionFactory;
    private Session session;

    @Before
    public void setUp() {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    @After
    public void tearDown() {
        if (session != null) {
            session.getTransaction().commit();
            session.close();
        }
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    public void testCreateAndRead() {
        // Create a new Person and Item
        Person person1 = new Person("John Doe", 30);
        Item item1 = new Item("Sample Item");
        person1.setItems(new ArrayList<>(Collections.singletonList(item1)));
        item1.setOwner(person1);

        session.persist(person1);

        // Read the created Person and Item
        Person retrievedPerson = session.get(Person.class, person1.getId());
        Item retrievedItem = session.get(Item.class, item1.getId());

        assertNotNull(retrievedPerson);
        assertNotNull(retrievedItem);

        assertEquals("John Doe", retrievedPerson.getName());
        assertEquals("Sample Item", retrievedItem.getItemName());
    }

    @Test
    public void testUpdate() {
        // Create a new Person
        Person person1 = new Person("John Doe", 30);
        session.persist(person1);

        // Update the Person's name
        person1.setName("Updated John Doe");
        session.merge(person1);

        // Read the updated Person
        Person retrievedPerson = session.get(Person.class, person1.getId());

        assertNotNull(retrievedPerson);
        assertEquals("Updated John Doe", retrievedPerson.getName());
    }

    @Test
    public void testDelete() {
        // Create a new Person
        Person person1 = new Person("John Doe", 30);
        session.persist(person1);

        // Delete the Person
        session.remove(person1);

        // Try to read the deleted Person (it should be null)
        Person retrievedPerson = session.get(Person.class, person1.getId());

        assertNull(retrievedPerson);
    }
}

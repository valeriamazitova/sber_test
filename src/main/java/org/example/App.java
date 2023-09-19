package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class demonstrates CRUD (Create, Read, Update, Delete) operations on Person and Item objects using Hibernate.
 * It includes database configuration, session management, and basic data manipulation.
 *
 * @author: Valeria Mazitova
 */
public class App
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    /**
     * Entry point of the program for performing CRUD operations on Person and Item objects.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main( String[] args )
    {
        // Adding our annotated classes Person and Item to Hibernate configuration
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        /**
         * Creating SessionFactory object that is responsible for creating and managing
         * database connections
         */
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Session opening and transaction begin
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Reading info from our database
            Person person = session.get(Person.class, 1);
            logger.info("read Person object from table: {}", person);

            Item item = session.get(Item.class, 1);
            logger.info("read Item object from table: {}", item);

            // Creating a record for the table
            Person person1 = new Person("test name", 25);
            Item item1 = new Item("test item for test person");

            person1.setItems(new ArrayList<>(Collections.singletonList(item1)));
            item1.setOwner(person1);

            logger.info("adding new Person to the table: {}", person1);
            logger.info("adding new Item to the table: {}", item1);
            session.persist(person1);

            /**
             * Updating previously created record
             * (there's no need to call session.persist(person1) because the object is
             * in the persistent (managed) state
             */
            person1.setName("Julia");
            logger.warn("updated Person was saved in the table: {}", person1);

            // Deleting a record from the table
            Person person2 = session.get(Person.class, 3);
            session.remove(person2);
            logger.warn("a Person was removed from the table {}", person2);

            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("an error occurred", e);
            throw e;
        }
    }
}

package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * created by: Mazitova Valeria
 *
 */
public class App
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();


//            прочитать данные из таблицы
            Person person = session.get(Person.class, 1);
            logger.info("read Person object from table: {}", person);

            Item item = session.get(Item.class, 1);
            logger.info("read Item object from table: {}", item);


            session.getTransaction().commit();
        }
    }
}

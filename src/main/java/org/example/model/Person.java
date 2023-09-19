package org.example.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

/**
 * @author: Valeria Mazitova
 */
@Entity
@Table(name = "person")
/**
 * Represents a person with a name and age. A person may own a list of items.
 */
public class Person {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "owner")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private List<Item> items;

    public Person() {}


    /**
     * Constructs a new Person object with the specified name and age.
     *
     * @param name The name of the person.
     * @param age  The age of the person.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Gets the unique identifier (ID) of the person.
     *
     * @return The ID of the person.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier (ID) of the person.
     *
     * @param id The new ID to set for the person.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name The new name to set for the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the age of the person.
     *
     * @return The age of the person.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the person.
     *
     * @param age The new age to set for the person.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the items list of the person.
     *
     * @return The list of Items of the person.
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Sets the list of Items of the person.
     *
     * @param items The new items list to set for the person.
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Returns a string representation of the Person object.
     *
     * @return A string in the format "Person{id=1, name='John', age=30}".
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

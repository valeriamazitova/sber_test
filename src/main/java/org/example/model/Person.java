package org.example.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

/**
 * @author: Valeria Mazitova
 */
@Entity
@Table(name = "person")
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
     * Person constructor to create Person object
     * and new Person record in the table
     * @param name
     * @param age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Get-method to access Person's id
     * @returns Person's id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets new id for the Person object
     * @param id integer value
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get-method to access Person's name
     * @returns Person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new name for Person
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get-method to access Person's age
     * @returns age
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @param age < 100
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get-method to access Person's item list
     * @return
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     *
     * @param items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     *
     * @return
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

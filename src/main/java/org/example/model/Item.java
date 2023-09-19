package org.example.model;

import jakarta.persistence.*;

/**
 * Represents an item with a unique identifier, item name, and an owner (a Person).
 * An item can be associated with a person who owns it.
 *
 * @author Valeria Mazitova
 */

@Entity
@Table(name = "item")
public class Item {
    /**
     * The unique identifier (ID) of the item.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The name of the item.
     */
    @Column(name= "item_name")
    private String itemName;

    /**
     * The owner of the item (a Person).
     */
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    /**
     * Constructs a new Item object with no specified name.
     */
    public Item() {}

    /**
     * Constructs a new Item object with the specified item name.
     *
     * @param itemName The name of the item.
     */
    public Item(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Gets the unique identifier (ID) of the item.
     *
     * @return The ID of the item.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier (ID) for the item.
     *
     * @param id The new ID to set for the item.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the item.
     *
     * @return The name of the item.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Sets the name of the item.
     *
     * @param itemName The new name to set for the item.
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Gets the owner of the item (a Person).
     *
     * @return The owner of the item.
     */
    public Person getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the item.
     *
     * @param owner The new owner (a Person) to set for the item.
     */
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    /**
     * Returns a string representation of the Item object.
     *
     * @return A string representing the Item object with its ID, item name, and owner.
     */
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", owner=" + owner +
                '}';
    }
}

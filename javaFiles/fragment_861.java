package view;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "People")
public class Person {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) // commented for manually set the id
    private int id;

    private String name;
    private String lastName;

    public Person(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public Person() {
    }
}
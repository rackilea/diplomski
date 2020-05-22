@Entity
public class House implements Serializable {
    @Id
    private int id;

    @OneToMany(mappedBy="house")
    private Set<Person> people;

    ... rest of your class
}


@Entity
public class Person implements Serializable {

    @Id
    private int id;

    @ManyToOne(targetEntity=House.class)
    private House house;

    @Column(name="person_name")
    private String name

    ... rest of your class

    public Person(House house, String name) {
       this.house = house;
       this.name = name;
    }
}
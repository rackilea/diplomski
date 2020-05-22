@Entity
public class Person {
    // all other fields

    @ManyToOne
    private Address address;

    // getters and setters
}

@Entity
public class Institution {
    // all other fields

    @ManyToOne
    private Address address;

    // getters and setters
}
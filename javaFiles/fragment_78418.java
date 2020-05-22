public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    @Embedded
    private Address address;

    //getter/setter
}

@Embeddable
public class Address {
    private String street;
    private String state;
    private int zipCode;

    //getter/setter
}
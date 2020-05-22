@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    @Embedded
    private Name name;
    @Embedded
    private Address address;
    private String phone;
    private String comment;
    public Customer() { }
}

@Entity
public class Name {
    private String given;
    private String surname;
    public Name() { }
}

@Embeddable
public class Address {
    private String street;
    private String houseNumber;
    private String zip;
    private String city;
    public Address() { };
}
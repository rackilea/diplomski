package example.model;

@XmlType(namespace = "http://www.example.org/customer", propOrder = {"id", "name", "address"})
public class Customer {

    private long id;
    private String name;
    private Address address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(namespace="http://www.example.org/address")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
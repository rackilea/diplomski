import java.io.Serializable;
public class Person implements Serializable {
    private String name;
    private transient Address address;
    public Person(String name)  { this.name = name; }
    public Address getAddress() { return address; }
    public String getName()     { return name; }
}
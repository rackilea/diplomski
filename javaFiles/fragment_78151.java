@XmlRootElement(name="address")
class Address {
    ...

    @XmlElement
    String street;
}

@XmlRootElement(name="person")
class Person {
    ...

    @XmlTransient
    Address address;

    @XmlElement
    public String getStreet() {
       return (address!= null) ? address.getStreet() : null;
    }
}
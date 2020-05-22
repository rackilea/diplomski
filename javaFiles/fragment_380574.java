@XmlType(name = "",propOrder = {"street","house"})
@XmlRootElement(name = "DI_Add")
public static class Address {

    private String street;
    private String house;

    @XmlElement(name = "DI_Street")
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    @XmlElement(name = "DI_House")
    public String getHouse() {
        return house;
    }
    public void setHouse(String house) {
        this.house = house;
    }
}

@XmlType(name = "", propOrder = {"name","add"})
@XmlRootElement(name = "DI_Customer")
public static class Customer {

    private String name;
    private Address add;

    @XmlElement(name = "DI_Name", required = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name = "DI_Add", required = true)
    public Address getAdd() {
        return add;
    }
    public void setAdd(Address add) {
        this.add = add;
    }
}
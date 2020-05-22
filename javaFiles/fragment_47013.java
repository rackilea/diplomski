public class Person {
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public int getId() { return id; }
    protected void setId(int id) { this.id = id; }

    private Address address;
    private int id;
}
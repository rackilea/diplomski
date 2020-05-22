public class Person {
    private List<Address> addresses;
    // properties, real getters and setters

    public Address getAddress() {
        if (this.addresses == null || this.addresses.isEmpty()) {
            return null;
        }
        return this.addresses.get(0);
    }

    public void setAddress(Address address) {
        if (this.addresses == null) {
            this.addresses = new ArrayList<Address>();
        }
        this.addresses.clear();
        this.addresses.add(address);
    }
}
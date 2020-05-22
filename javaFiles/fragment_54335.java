class PhoneBookEntry {
    public final String firstName;
    public final String lastName;
    public final String phoneNumber;

    public Entry(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    //... equals + hashcode implementation
}
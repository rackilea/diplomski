public class Person {

    private String firstname;
    private String lastname;
    private PhoneNumber phone;
    private PhoneNumber fax;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setPhone(PhoneNumber phone) {
        this.phone = phone;
    }

    public void setFax(PhoneNumber fax) {
        this.fax = fax;
    }

    @Override
    public String toString() {
        return "Person{" + "firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone + ", fax=" + fax + '}';
    }

}
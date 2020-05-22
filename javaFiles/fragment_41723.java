import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Person")
public class Person {

    private String firstName;

    private String lastName;

    private String address;

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public final String getAddress() {
        return address;
    }

    public final void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "FirstName: " + firstName + " LastName: " + lastName + " Address: " + address;
    }

}
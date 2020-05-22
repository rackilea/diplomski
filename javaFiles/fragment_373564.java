@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Person")
public class Person {    
    @XmlElement(name = "firstName")
    protected String firstName;    
    @XmlElement(name = "lastName")
    protected String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }
}
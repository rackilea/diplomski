@XmlRootElement(name= "PersonInputs")
@XmlAccessorType(XmlAccessType.NONE)
public class Person
{
    @Id @GeneratedValue
    private Long id; 

    private String firstName = "foo";

    private String lastName = "bar";

    // getters/setters

    @XmlElement(name= "Input")
    Input getFirstNameXML()
    {
       return new Input(String.class.getSimpleName(), "firstName", firstName);
    }

    @XmlElement(name= "Input")
    Input getLastNameXML()
    {
       return new Input(String.class.getSimpleName(), "lastName", lastName);
    }
}
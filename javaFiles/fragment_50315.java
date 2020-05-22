@XmlRootElement(name= "PersonInputs")
@XmlAccessorType(XmlAccessType.NONE)
public class Person
{
    private Long id; 

    private String firstName = "foo";

    private String lastName = "bar";

    // getters/setters

    @XmlElement(name = "Input")
    List<Input> getList() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException
    {
       return getInputs(this, "firstName", "lastName"); // fields names
    }
}
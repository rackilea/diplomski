@XmlRootElement(name="Person")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Person {
    private String name;

    @XmlElement (name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }       
}
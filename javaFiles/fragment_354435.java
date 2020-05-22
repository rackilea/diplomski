@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "child")
public class Child {
    @XmlElement(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
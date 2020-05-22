@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Name", propOrder = {
    "all",
    "link"
})
public class Name {

    @XmlElement(name = "All", required = true)
    protected String all;
    @XmlElement(required = true)
    protected String link;

    // getters and setters

    @Override
    public String toString() {
        return all;
    }
}
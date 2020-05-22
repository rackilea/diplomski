@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "element", propOrder = {"sub1", "sub2"})
@XmlRootElement
public class Element {

    @XmlElement(required = true)
    public String sub1;

    @XmlElementRef(name = "sub2", required = false)
    public JAXBElement<String> sub2;

    // ...
}
@XmlAccesorType(XmlAccessType.FIELD)
public class Company {

    @XmlElementWrapper
    @XmlElement(name="elementref")
    @XmlIDREF
    private List<Employee> employees;
}
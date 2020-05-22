@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    private Company company;

    @XmlElement(name="employee")
    private List<Employee> employees;

}
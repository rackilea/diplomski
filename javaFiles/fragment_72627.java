@XmlAccessorType(value = XmlAccessType.NONE)
public class Department {


    @XmlElement
    private Long id
    @XmlElement
    private String name 
    @XmlElement
    private List<Employee> employees;

    // +accessor methods

}
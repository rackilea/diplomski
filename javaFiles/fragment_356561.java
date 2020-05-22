@XmlRootElement(name="employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

private Integer id;
private String firstName;
private String lastName;
private Integer income;

private Map<Integer,Employee> employeeMap=new HashMap<>();    
//getters and Setters

}
public class Department {
  @XmlAttribute(name = "name")
  private String name;

  @XmlElement(name = "employee")
  private List<Employee> employee = new ArrayList<>();

  // Getters and setters
}
@Record
public class Department {

  @Segment(minOccurs = 0, maxOccurs = -1, collection = List.class)
  private List<Employee> employeeDetails;

//getters and setters
}
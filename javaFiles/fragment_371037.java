@ContextHierarchy(
@ContextConfiguration(name = "child",
locations = "/manager-context.xml",
 inheritLocations = false //add this line to your code
))
public class ManagerTests extends EmployeeTests{

}
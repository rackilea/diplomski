@Path("/employee")
public class EmployeeService {
    @GET
    @Path("/get")
    @Produces("application/xml")
    public Employee getEmployee() {
        Employee emp = new Employee();
        emp.setName("Test Employee");
        return emp;
    }

    @POST
    @Path("/create")
    @Consumes("application/xml")
    public Response createEmployee(Employee emp) {
        // Write your code here to save the employee
    }
}
@RestController

public class EmployeeRestController {


    @RequestMapping(value = "/employees")
    public Wrapper getEmployees() {

        Wrapper wrapper = getWrapper();
        return wrapper;

    }

    public Wrapper getWrapper() {
        Wrapper wrapper = new Wrapper();
        List<Employee> employees = getEmployee();
        List<Organizations> organizations = getOrg();

        wrapper.setEmployees(employees);
        wrapper.setOrganizations(organizations);

        return wrapper;
    }

    public List<Employee> getEmployee() {
        Employee employee1 = new Employee(101, "abc", "abc", "SE");
        Employee employee2 = new Employee(102, "def", "def", "SE");
        Employee employee3 = new Employee(103, "xyz", "xyz", "SE");

        List<Employee> employees = new ArrayList<Employee>();


        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        return employees;
    }

    public List<Organizations> getOrg() {

        Organizations organizations1 = new Organizations();
        organizations1.setName("Google");
        Organizations organizations2 = new Organizations();
        organizations2.setName("Facebook");
        Organizations organizations3 = new Organizations();
        organizations3.setName("Apple");

        List<Organizations> organizations = new ArrayList<Organizations>();
        organizations.add(organizations1);
        organizations.add(organizations2);
        organizations.add(organizations3);

        return organizations;

    }
}


public class Wrapper {

    private List<Employee> employees;
    private List<Organizations> organizations;
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    public List<Organizations> getOrganizations() {
        return organizations;
    }
    public void setOrganizations(List<Organizations> organizations) {
        this.organizations = organizations;
    }
}
import java.util.List;

public class EmpDetl {

    private List<Employee> employeeDetl;
    public List<Employee> getEmployeeDetl() {
        return employeeDetl;
    }
    public void setEmployeeDetl(List<Employee> empLists) {
        this.employeeDetl = empLists;
    }
    @Override
    public String toString() {
        return "EmpDetl [empLists=" + employeeDetl + "]";
    }

}
public class Controller {

    public Controller() { }

    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> emps = dao.selectAllEmployees();

        for (Employee e : emps) { 
            // etc...
        }
    }
}
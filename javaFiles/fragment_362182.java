@Component
public abstract class EmployeeService {
    public abstract void getEmployee(int employeeId);

    public void fallbackMethod(int employeeid) {
        threadLocalUtil.addDataToThreadLocalMap("ErrorResponse", "Fallback response:: No employee details available temporarily");
    }
}
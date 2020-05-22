public class EmployeeFactory {
    public static Employee toEmployee( User user ) {
        Employee emp = new Employee();
        emp.setUserId( user.getUserId() );
        emp.setUserName( user.getUserName());
        return emp;
    }
}
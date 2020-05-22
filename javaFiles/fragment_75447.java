import org.company.Employee;
import org.company.Manager;
public class TestManager {
    public static void main(String[] args) {
        Employee bill = new Employee();
        bill.name = "Bill";
        bill.employeeID = "1";

        Employee george = new Employee();
        george.name = "George";
        george.employeeID = "3";

        Manager jill = new Manager();
        jill.name = "Jill";
        jill.employeeID = "1234";
        jill.subordinates.add(bill);
        jill.subordinates.add(george);

        //foreach
        for (Employee emp : jill.subordinates) {
            System.out.println(emp.name);
        }
    }
}
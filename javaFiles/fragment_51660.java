import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    public static List<Employee> getEmployeeList(List<User> users) {
        List<Employee> employees = new ArrayList<>();
        if (users != null) {
            employees = users.stream()
                    .filter(u -> u instanceof Employee)
                    .map(u -> (Employee) u)
                    .collect(Collectors.toList());
        }
        return employees;
    }
}
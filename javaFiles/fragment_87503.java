public class EmployeeTest {

    public static void main(String[] args) {

        Employee raise1= new Employee("Betty","Jones",4000.0);
        Employee raise2= new Employee("Sally","Mae",6000.0);

        //Print statements for the employee's name and salary
        System.out.printf("Employee #1\nFirst Name: %s\nLast Name: %s\n\n" +
                "Salary: $%.2f",
                raise1.getName(),
                raise1.getLastName(),
                raise1.getSalary());

        System.out.printf("\nHer raise will be: $%.2f",
                raise1.raise(raise1.getSalary()));


        System.out.printf("\n\nEmployee #2\nFirst Name: %s\nLast Name: %s\n\n" +
                "Salary: $%.2f",
                raise2.getName(),
                raise2.getLastName(),
                raise2.getSalary());

        System.out.printf("\nHer raise will be: $%.2f\n",
                raise2.raise(raise2.getSalary()));

    }
}
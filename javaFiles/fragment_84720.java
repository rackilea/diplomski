import java.util.Scanner;

public class EmployeeTester {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // can make workers and bosses able to be processed polymorphically
        // by assinging their references to Employee variables, since 
        // and Employee is the supertype of each, a Worker "is an" Employee
        // and a Boss "is an" Employee.
        Employee worker1 = new Worker("Bob", "Worker");
        Employee worker2 = new Worker("Sue", "Bush", "Password1"); 
        Employee worker3 = new Worker();
        Employee boss1 = new Boss("Jenny", "Boss");
        Employee boss2 = new Boss("Bill", "OtherBoss", "Password2");
        Employee boss3 = new Boss();

        // if you're going to have a lot of workers and bosses, and you don't
        // need named variables for each because their info will be included
        // in their constructors, you could do this
        Employee[] employees = {new Worker("Bob", "Bailey", "myPassword"),
                                new Worker("Sue", "Sarandon", "123Seven"),
                                new Boss("Jenny", "Strayhorn", "hardPassword"),
                                new Boss("Billy", "MeanGuy", "pifiaoanaei")};

        // then, you could iterate through this list to check if a password
        // entered matches a firstName, lastName, and password combination
        // for ANY type of employee in the array, then call the getMenu()
        // method on that employee, like so: (This could all be in a loop
        // if you wanted to process multiple Employees...)

        System.out.println("Enter firstName:");
        // you figure out which Scanner method to use!
        String firstName = input._____(); 

        System.out.println("Enter lastName:");
        String lastName = input._____();

        System.out.println("Enter password:");
        String password = input._____();

        // figure out what get____() method of the Employee class
        // needs to be called in each case, and what it should be 
        // compared to with the .equals() method.
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].get______().equals(______) &&
                employees[i].get______().equals(______) &&
                employees[i].get______().equals(______)) {

                // if all of those conditions are true, print the menu
                // for this employee
                employees[i].get_____();

                // you could do more stuff here....

                // breaks out of the loop, no need to check for anymore employees
                break;
            }
        }
    }
}
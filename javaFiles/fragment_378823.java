import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JDialog;

public class EmployeeTest
{

    public static void main( String args[] )
    {
        // create Scanner to obtain input from command window
        Scanner input = new Scanner(System.in);
        Employee employee1 = new Employee( "Bo", "Jackson", 8875.00 );
        Employee employee2 = new Employee( "Cam", "Newton", 13150.75 );

        // display employees
        System.out.printf( "Employee 1: %s %s; Yearly Salary: %.2f\n",
                employee1.getFirstName(), employee1.getLastName(),
                12 * employee1.getMonthlySalary() );
        System.out.printf( "Employee 2: %s %s; Yearly Salary: %.2f\n",
                employee2.getFirstName(), employee2.getLastName(),
                12 * employee2.getMonthlySalary() );

        JDialog.setDefaultLookAndFeelDecorated(true);
        int response1 = JOptionPane.showConfirmDialog(null, "Do you wnat to change an employee's salary?", 
                "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response1 == JOptionPane.NO_OPTION)// if NO is clicked
            {
                System.out.println("See you next time");
            } else if (response1 == JOptionPane.YES_OPTION)// if YES is clicked
            {
                // option to change the salary for employee 1
                int response2 = JOptionPane.showConfirmDialog(null, "Would you like to change " + employee1.getFirstName() + " " + employee1.getLastName() + "'s salary:", 
                        "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response2 == JOptionPane.NO_OPTION)// if NO is clicked
                {
                    // option to change the salary for employee 2
                    int response3 = JOptionPane.showConfirmDialog(null, "Would you like to change " + employee2.getFirstName() + " " + employee2.getLastName() + "'s salary:", 
                            "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response3 == JOptionPane.NO_OPTION)
                            {
                                System.out.println("See you next time");
                            } else if (response3 == JOptionPane.YES_OPTION)// if YES is clicked
                            {
                                // enter new salary for employee 2
                                System.out.println( "Enter " + employee2.getFirstName() + " " + employee2.getLastName() + "'s new salary:" );
                                double newSalary2 = input.nextDouble();
                                employee2.setNewMonthlySalary( newSalary2 );

                                // display unchanged salary for employee 1
                                System.out.printf( "Employee 1: %s %s; Yearly Salary: %.2f\n",
                                        employee1.getFirstName(), employee1.getLastName(),
                                        12 * employee1.getMonthlySalary() );

                                // display new yearly salary for employee 2
                                System.out.printf( "Employee 2: %s %s; Yearly Salary: %.2f\n",
                                        employee2.getFirstName(), employee2.getLastName(),
                                        12 * newSalary2 );
                            } else if (response3 == JOptionPane.CLOSED_OPTION)// if JOPTIONPANE is closed
                            {
                                System.out.println("JOptionPane closed");
                            }// END RESPONSE 3
                } else if (response2 == JOptionPane.YES_OPTION)// if YES is clicked
                {
                    // enter new salary for employee 1
                    System.out.println( "Enter " + employee1.getFirstName() + " " + employee1.getLastName() + "'s new salary:" );
                    double newSalary1 = input.nextDouble();
                    employee1.setNewMonthlySalary( newSalary1 );

                    // display new yearly salary for employee 1
                    System.out.printf( "Employee 1: %s %s; Yearly Salary: %.2f\n",
                            employee1.getFirstName(), employee1.getLastName(),
                            12 * newSalary1 );
                    // display unchanged salary for employee 2
                    System.out.printf( "Employee 2: %s %s; Yearly Salary: %.2f\n",
                            employee2.getFirstName(), employee2.getLastName(),
                            12 * employee2.getMonthlySalary() );
                } else if (response2 == JOptionPane.CLOSED_OPTION)// if JOPTIONPANE is closed
                {
                    System.out.println("JOptionPane closed");
                }// END RESPONSE 2
                {

                }

            } else if (response1 == JOptionPane.CLOSED_OPTION)// if JOPTIONPANE is clicked
            {
                System.out.println("JOptionPane closed");
            }// END RESPONSE 1

    } // end main

 } // end class EmployeeTest
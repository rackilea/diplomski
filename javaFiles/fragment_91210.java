import java.io.*;
public class EmployeeTest {

   public static void main(String args[]) {
      /* Create two objects using constructor */
      Employee empOne = new Employee("James Smith");
      Employee empTwo = new Employee("Mary Anne");
      Employee empThree = new Employee("Alex Johnson");

      // Invoking methods for each object created
      empOne.empAge(26);
      empOne.empDesignation("Senior Software Engineer");
      empOne.empSalary(1000);
      empOne.empFavoriteColor("Green");
      empOne.printEmployee();

      empTwo.empAge(21);
      empTwo.empDesignation("Software Engineer");
      empTwo.empSalary(500);
      empTwo.empFavoriteColor("Blue");
      empTwo.printEmployee();

      empThree.empAge(16);
      empThree.empDesignation("Software Developer" );
      empThree.empSalary(250);
      empThree.empFavoriteColor("Orange");
      empThree.printEmployee();
   }
}
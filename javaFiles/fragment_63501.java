public class Employee {
   // Count of the created employees
   public static int count = 0;

   // ... Class fields

   public Employee(
       final Department department,
       final String name,
       final String surname) {
      // ... Assign arguments to class fields

      // A new employee has been created. Increment the counter!
      ++count;    
   }

   ... 
}
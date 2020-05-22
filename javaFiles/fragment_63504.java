public static void main(final String[] args) {
   final Department dep1 = new Department("dep1");
   dep1.addEmployee(new Employee("Name1", "Surname1"));
   dep1.addEmployee(new Employee("Name2", "Surname2"));

   final Department dep2 = new Department("dep2");
   dep2.addEmployee(new Employee("Name3", "Surname3"));

   // Now we have two departments.
   // We can retrieve the count of employees for each using
   final int dep1Count = dep1.getEmployeeCount();
   final int dep2Count = dep2.getEmployeeCount();

   // And we can have the total
   final int total = dep1Count + dep2Count;
}
public void retrieveEmployee() {
   for (int i = 0; i < employees.size(); i++) {

       //add this line
       Employee employee = employees.get(i);

       System.out.println("ID: " + employee.ID + END_OF_LINE + "Name: " + employee.name + END_OF_LINE + "salary: " + employee.salary);
   }
}
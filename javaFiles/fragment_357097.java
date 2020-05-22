public static Employee createEmployee(int number){

   Scanner input = new Scanner(System.in);
   System.out.printf("Enter full name of employee %d, separated by spaces: ", number);
   String fName = input.next();
   String lName = input.next();
   return new Employee(fName, lName);
}
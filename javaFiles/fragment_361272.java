public class Employee { 

    public String FirstName, LastName; // String instance variables

    public double Salary; //double floating-point instance variable

  //should introduce and initialize the constructor Employee
    public Employee( String fName, String lName, double empSalary ) {
         FirstName = fName;
         LastName = lName;
         Salary = empSalary;
     }
   public void setFirstName( String Steven ) // set the First Name 
   { 
       FirstName = Steven; 
   }

    public void setLastName( String Dorsey ) // set the Last Name
     {
         LastName = Dorsey;
     }
    public void setSalary( double empSalary ) // set the Employee Salary
    {
     Salary = empSalary;
    }

    public String getFirstName()
    {
        return FirstName;
    }
    public String getLastName()
    {
        return LastName;
    }
    public double getSalary(){
        return Salary;
    }

    public void displayEmployee(){
        System.out.println("FirstName : "+FirstName);
        System.out.println("LastName : "+LastName);
        System.out.println("Salary : "+Salary);
    }
  //main method begins program execution
    public static void main( String[] args )
    {
     // create Scanner to enable user input in Dos
     Scanner input = new Scanner(System.in );
     System.out.println("Enter employee details :");
       Employee emp=new Employee(input.next(), input.next(), input.nextDouble());
       emp.displayEmployee();
    }

}// End of class
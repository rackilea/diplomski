public class Employee {

   //instance variable
   private String name;
   private String lastName;
   private double salary;

    //getters
    public String getLastName() {
        return lastName;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }

    public double raise(double raise){
        salary = salary + (salary*.1);
        return salary;
    }

    //constructor
    public Employee(String name, String lastName, double salary){

        this.name = name;
        this.lastName = lastName;
        this.salary = salary;

    }

}
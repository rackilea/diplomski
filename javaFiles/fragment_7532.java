public class Employees {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employees employee = new Employees("name", "address", "dob");
        employee.printDetails();
    }

    //properties
    private String name;
    private String ID;
    private String salary;

    //constructor
    public Employees (String name, String address, String dob) {
        this.name = name;
        this.ID = ID;
        this.salary = salary;
    }

    //method to print details on employees
    public void printDetails() {
        System.out.println("Employee name: " +this.name);
        System.out.println("ID: "+ this.ID);
        System.out.println("Annual Salary: " + this.salary);
    }
}
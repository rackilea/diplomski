// abstract class, CANNOT be instantiated but can be used as the supertype
// in an ArrayList<Employee>
public abstract class Employee {

    private String firstName;
    private String lastName;  
    private String password;

    public Employee() {
        // don't have to do anything, just need this so you can instantiate
        // a subclass with a no-arg constructor
    }

    // constructor that takes only the name of the Employee
    public Employee(String firstName, String lastName) {
        this(firstName, lastName, null);
    }

    // constructor that takes name and password
    public Employee(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // and so on, for the lastName and password....

    // you must implement this specifically in any subclass!
    public abstract void getMenu();
}
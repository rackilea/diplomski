public class Employee
{
    private int salary = 2000;
    public void getSalary() {
        return salary;
    }
}

public class Manager extends Employee
{
    private int salary = 5000;
    @Override
    public void getSalary () {
        return salary;
    }
}

...

Employee emp_new = new Manager();
System.out.println(emp_new.getSalary()); // will print 5000
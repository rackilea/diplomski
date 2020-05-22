public class Nurse implements Employee, Person {

    private final Employee employee;
    private final Person person;

    public Nurse(String name, int age, double salary) {
        person = new PersonImpl(name, age);
        employee = new EmployeeImpl(salary);
    }

    @Override
    public double getSalary() {
        return employee.getSalary();
    }

    @Override
    public String getName() {
        return person.getName();
    }

    @Override
    public int getAge() {
        return person.getAge();
    }
}
class Employee {

    private String name;
    private int id;
    private String city;
    private int salary;

    public Employee(String name, int id, String city, int salary) {
        this.name = name;
        this.id = id;
        this.city = city;
        this.salary = salary;
    }

    // @Override
    public String toString() {
        return "Employee: name = " + name + "; Id = " + id + "; City = " + city
                + "; Salary = " + salary;
    }
}
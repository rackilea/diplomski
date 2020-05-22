public final class EmployeeImpl implements Employee {
    private final double salary;

    public EmployeeImpl(double salary) {
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
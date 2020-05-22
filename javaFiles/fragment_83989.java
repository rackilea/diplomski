EmployeeFactory empFactory = new EmployeeFactory() {
    @Override
    public Employee getEmployee(String name, int age) {
        return new Employee(name, age);
    }
};
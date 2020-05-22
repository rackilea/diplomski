class Employee {
    private final String id;
    private final String name;
    private final Number salary; //generic type salary

    public Employee(String id,String name,Number salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Number getSalary() {
        return salary;
    }

}
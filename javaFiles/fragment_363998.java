class Personnel {
    private Map<String, Employee> employees = new HashMap<>();

    public void addEmployee(Employee employee) {
        employees.put(employee.getName(), employee);
    }

    public Details getEmployeeDetails(String name) {
        return employees.get(name).getDetails();
    }
}

class Employee {
    private String name; //could be stored in Details
    private Details details;

    public Employee(String name, Details details) {
        this.details = details;
    }

    public Details getDetails() {
        return details;
    }

    public String getName() {
        return name;
    }
}

class Details {
    private PayInfo payInfo;
    private Address address;

    public Details(PayInfo payInfo, Address address) {
        this.payInfo = payInfo;
        this.address = address;
    }

    public PayInfo getPayInfo() {
        return payInfo;
    }

    public Address getAddress() {
        return address;
    }
}
public class Employee {
    private String employee;
    public String id, name, address;

    public Employee(String id, String name, String address) {
        this.employee = "employee";
        this.id = id;
        this.name = name;
        this.address = address;
    }

    Employee(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEmployee() {
        return employee;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
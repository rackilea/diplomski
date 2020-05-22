public class Employee{
    private String name;
    private String department;
    private String designation;

    public Employee(String name,String dept,String designation){
        this.name = name;
        this.department = dept;
        this.designation = designation;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
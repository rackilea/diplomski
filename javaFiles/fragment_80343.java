public class Employee extends EmploymentEntity {
    private String name ;

    public Employee(String name) {
        this.name = name ;
    }

    @Override
    public String getEmployeeName() {
        return name ;
    }

    public void setEmployeeName(String name) {
        this.name = name ; 
    }
}
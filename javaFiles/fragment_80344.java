public class Factory extends EmploymentEntity {

    private String name ;
    private double size ;
    private List<Employee> employees ;

    public Factory(String name, double size) {
        this.name = name ;
        this.size = size ;
        this.employees = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name ;
    }

    public void setName(String name) {
        this.name = name ;
    }

    @Override
    public Double getSize() {
        return size ;
    }

    public void setSize(double size) {
        this.size = size ;
    }

    public List<Employee> getEmployees() {
        return employees ;
    }
}
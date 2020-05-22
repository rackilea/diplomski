public class Department(){
    public void setOrganisation(Organisation organisation){
        this.organisation = organisation;

        if(! organisation.getDepartments().contains(department)){
            organisation.addDepartment(department);
        }
    }
}

public class Organisation(){

    public List<Department> getDepartments(){
        return Collections.unmodifiableList(departments);
    }

    public void addDepartment(Department departmenmt){
        departments.add(department);

        if(department.getOrganisation() != this){
            department.setOrganisation(this);
        }
    }
}
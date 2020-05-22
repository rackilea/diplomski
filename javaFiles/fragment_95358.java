public class Employee{

    @OneToMany(targetEntity = EmployeeRole.class, mappedBy="employee", fetch = FetchType.EAGER,  cascadeType=CascadeType.ALL)
    private Set<EmployeeRole> employeeRoles;
}


public class Employer{

    @OneToMany(targetEntity = Employee.class, mappedBy="employer", fetch = FetchType.EAGER, cascadeType=CascadeType.ALL)
    private Set<Employee> employees;
}
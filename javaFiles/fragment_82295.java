public Employee getEmployee() {
    if(employee == null) {
        // some business-level exception
        throw new EmployeeAbsentException(this.toString());
    }
    return employee;
}

// in Employee class
public Dept getDept() {
    if(dept == null) {
        throw new EmployeeHasNoDeptException(this);
    }
    return dept;
}
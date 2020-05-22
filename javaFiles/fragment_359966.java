@ValueRangeProvider(id = "employeeRange")
public List<Employee> getEmployees() {
    return employees;
}

@PlanningEntityCollectionProperty
public List<VisitAssignment> getVisitAssignments() {
    return visitAssignments;
}
@OneToMany(mappedBy = "employer")
List<Employee> employees = new ArrayList<>();

public List<Employee> getEmployees() {
    return org.apache.commons.lang.SerializationUtils.clone(employees);
}
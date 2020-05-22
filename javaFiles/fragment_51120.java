@PostMapping("/employee")
public Employee create (@RequestBody EmployeeDTO employeeDTO){

    Department department = departmentService.get(employeeDTO.getDepartmentId());

    Employee employee = new Employee();
    employee.setId(employeeDTO.getId());
    employee.setName(employeeDTO.getName());
    employee.setDepartment(department);

    return employeeService.create(employee);
}
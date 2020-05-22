Set<Employee> employeeSet = inCompanyBean.getEmployees();

for (Employee outer : employeeSet) {
    for (Employee inner : employeeSet) {
        if (inner == outer) continue;

        // do the processing
    }
}
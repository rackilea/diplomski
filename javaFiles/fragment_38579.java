Set<Employee> employeeSet = inCompanyBean.getEmployees();
Employee[] employees = employeeSet.toArray(new Employee[0]);
int n = employees.length;

for (int i = 0; i < n; ++i) {
    Employee outer = employees[i];
    for (int j = i + 1; j < n; ++j) {   // note start value of 'j'
        Employee inner = employees[j];

        // do the processing
    }
}
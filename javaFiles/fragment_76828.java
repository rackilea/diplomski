EmployeeStore employeeStore = new EmployeeStore();
employeeStore.add(new Employee ("James O' Carroll", 18,"hotmail.com"));
employeeStore.add(new Employee ("Andy Carroll", 1171,"yahoo.com"));
employeeStore.add(new Employee ("Luis Suarez", 7,"gmail.com"));

// Remove a certain employee
employeeStore.remove("Andy Carroll");

// Remove all employees
employeeStore.clear();
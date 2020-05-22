// Prepare Employee key with all available search by keys (6 in my case)
EmplyeeKey key = new EmplyeeKey();
key.setField1("field1_value");
key.setField2("field2_value");
//Setting remaining 4 fields

// Create new Employee ans set the search key
Employee employee = new Employee();
employee.setEmployeeKey(key);


// Call the findAll by passing an Example of above Employee object
List<Employee> result = employeeRepository.findAll(Example.of(employee));
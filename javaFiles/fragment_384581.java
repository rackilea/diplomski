List<Employee> listOfEmp = new ArrayList<Employee>();

// Add employee to list
listOfEmp.add(new Employee("sarah1", 101, "orny", 13000));
listOfEmp.add(new Employee("sarah2", 102, "orny", 13000));
listOfEmp.add(new Employee("sarah3", 103, "orny", 13000));

// Iterate and print employee list
for (Employee employee : listOfEmp)
    System.out.println(employee);
ArrayList<Employee> employeeList = new ArrayList<Employee>();
// Or better yet: List<Employee> employeeList = new ArrayList<>();

employeeList.add(new createPerHourEmployee(1, "asd", 1300));
employeeList.add(new createFixedEmployee(7, "asds", 14025));
employeeList.add(new createPerHourEmployee(2, "nikan", 1230));
employeeList.add(new createPerHourEmployee(3, "nikalo", 12330));
employeeList.add(new createFixedEmployee(6, "aaaa", 14025));
employeeList.add(new createFixedEmployee(4, "nikaq", 140210));
employeeList.add(new createFixedEmployee(5, "nikas", 124000));
Employee.add(new createFixedEmployee(6, "nikab", 14025));


employeeList.sort(Comparator.comparing(Employee::getMonthSalary)
      .thenComparing(Employee::getEmployeeName));
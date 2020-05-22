double salary = mainMap.values().stream()
        .flatMap(m -> m.values().stream())
        .map(Employee::getSalary)
        .mapToDouble(Double::doubleValue)
        .sum();

System.out.println("Total salary: " + salary);
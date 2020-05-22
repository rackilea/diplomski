List<Employee> result = employees.stream()
        .filter(employee ->
                (employee.getName().equalsIgnoreCase("Sachin Tendulkar") && employee.getAge() == 36)
                        ||
                        (employee.getName().equalsIgnoreCase("Rahul Dravid") && employee.getAge() == 40)
        ).collect(Collectors.toList());
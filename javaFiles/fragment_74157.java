boolean isPresent = employees.stream()
        .anyMatch(employee ->
                (employee.getName().equalsIgnoreCase("Sachin Tendulkar") && employee.getAge() == 36)
                        ||
                        (employee.getName().equalsIgnoreCase("Rahul Dravid") && employee.getAge() == 40)
        );
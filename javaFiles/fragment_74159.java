List<Employee> listToFind = Arrays.asList(
        new Employee("Sachin Tendulkar", 36),
        new Employee("Rahul Dravid", 40)
);

boolean isPresent = employees.containsAll(listToFind);
public List<Person> transform(List<Employee> employees) throws Throwable {
    return employees.stream()
            .filter(Objects::nonNull)
            .collect(Collectors.mapping(this::transform, Collectors.toList()));
}

public Person transform(Employee it) {
    return new Person(it.firstName, it.lastName, it.email);
}
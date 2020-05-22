final List<Employee> employees = Arrays.asList(
    new Employee(100, "Fred", 10),
    new Employee(110, "Bill", 30),
    new Employee(120, "Eric", 10),
    new Employee(130, "Janet", 10));
final List<Employee> result = new ArrayList<Employee>();
Linq4j.asEnumerable(employees)
    .where(
        new Predicate1<Employee>() {
          public boolean apply(Employee e) {
            return e.name.contains("e");
          }
        })
    .into(result);
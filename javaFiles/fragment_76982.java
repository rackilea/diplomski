@Transactional
public void createOrUpdateEmployee(String firstName, String lastName) {
  for (int i = 0; i < 10; i++) {
    Employee employee = repository.findByLastName(lastName);
    if (employee == null) {
      employee = new Employee(firstName, lastName);
      if (i > 0) {
        throw new IllegalStateException("This can never happen!");
      }
    }

    log.info(employee);

    repository.save(employee);
  }
}
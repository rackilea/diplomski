public List<Customer> search(Customer customer) {
  ExampleMatcher matcher = ExampleMatcher
            .matching()
            .withIgnoreCase()
            .withIgnoreNullValues()
            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
            .withMatcher("name", startsWith())
            .withIgnorePaths("id");
  Example<Customer> query = Example.of(customer, matcher);

  return repository.findAll(query);
}
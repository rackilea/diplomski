Person p = new Person();
p.setLastName("Smith");

ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("age").withIgnoreNullValues();

Example criteria = Example.of(p, matcher);
List<Person> foundPersons = personRepository.findAll(criteria);
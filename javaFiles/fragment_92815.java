Example<Person> example = Example.of(new Person("Jon", "Snow"));
repo.findAll(example);


ExampleMatcher matcher = ExampleMatcher.matching().
    .withMatcher("firstname", endsWith())
    .withMatcher("lastname", startsWith().ignoreCase());

Example<Person> example = Example.of(new Person("Jon", "Snow"), matcher); 
repo.count(example);
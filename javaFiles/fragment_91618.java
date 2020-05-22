Person p = new Person();
p.setLastName("Smith");

Example criteria = Example.create(p).setPropertySelector(
    Example.NotNullOrZeroPropertySelector.INSTANCE
);
List<Person> foundPersons = session.createCriteria(Person.class).add(criteria).list();
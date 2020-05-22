MutableList<Person> people = Lists.mutable.with(
        new Person(UUID.randomUUID(), "Bob", football, handball),
        new Person(UUID.randomUUID(), "Tom", football, basketBall, tennis),
        new Person(UUID.randomUUID(), "Tim", climbing, handball, football),
        new Person(UUID.randomUUID(), "Marc", football, basketBall),
        new Person(UUID.randomUUID(), "Gerard", tennis, handball),
        new Person(UUID.randomUUID(), "Claudia", running, handball),
        new Person(UUID.randomUUID(), "Sara", football, climbing),
        new Person(UUID.randomUUID(), "Laura", football),
        new Person(UUID.randomUUID(), "Mo", football, tennis));

MutableList<String> top3Names =
        people.countByEach(Person::getSports)
                .topOccurrences(3)
                .collect(pair -> pair.getOne().getName());

MutableList<String> expected =
        Lists.mutable.with("Football", "Handball", "Tennis");

Assert.assertEquals(expected, top3Names);
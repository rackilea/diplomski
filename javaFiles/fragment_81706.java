// you'll have to write or download a Tuple class in Java, (.NET ships with one)

// create our map
Map<String, Tuple2<Person, Person> peopleByForename = new HashMap<>();

// populate it
peopleByForename.put("Bob", new Tuple2(new Person("Bob Smith",
                                       new Person("Bob Jones"));

// read from it
Tuple<Person, Person> bobs = peopleByForename["Bob"];
Person bob1 = bobs.Item1;
Person bob2 = bobs.Item2;
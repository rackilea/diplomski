// create our maps
Map<String, Person> firstPersonByForename = new HashMap<>();
Map<String, Person> secondPersonByForename = new HashMap<>();

// populate them
firstPersonByForename.put("Bob", new Person("Bob Smith"));
secondPersonByForename.put("Bob", new Person("Bob Jones"));

// read from them
Person bob1 = firstPersonByForename["Bob"];
Person bob2 = secondPersonByForename["Bob"];
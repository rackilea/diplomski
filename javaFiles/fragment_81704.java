// create our map
Map<String, List<Person>> peopleByForename = new HashMap<>();    

// populate it
List<Person> people = new ArrayList<>();
people.add(new Person("Bob Smith"));
people.add(new Person("Bob Jones"));
peopleByForename.put("Bob", people);

// read from it
List<Person> bobs = peopleByForename["Bob"];
Person bob1 = bobs[0];
Person bob2 = bobs[1];
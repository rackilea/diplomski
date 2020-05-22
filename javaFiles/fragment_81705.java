// define our wrapper
class Wrapper {
    public Wrapper(Person person1, Person person2) {
       this.person1 = person1;
       this.person2 = person2;
    }

    public Person getPerson1 { return this.person1; }
    public Person getPerson2 { return this.person2; }

    private Person person1;
    private Person person2;
}

// create our map
Map<String, Wrapper> peopleByForename = new HashMap<>();

// populate it
Wrapper people = new Wrapper();
peopleByForename.put("Bob", new Wrapper(new Person("Bob Smith"),
                                        new Person("Bob Jones"));

// read from it
Wrapper bobs = peopleByForename.get("Bob");
Person bob1 = bobs.getPerson1;
Person bob2 = bobs.getPerson2;
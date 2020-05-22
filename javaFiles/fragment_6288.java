public class Person {   
    String name;

    // For identification purposes.
    public Person(String name) {
        this.name = name;
    }

    HashMap<String, Person> friends = new HashMap<String, Person>();
}
class SomeClass {
    public static void main(String[] args) {
        Person person = new Person("John", 16);
        HashMap<String, Person> people = new HashMap<String, Person>();
        people.put(person.getName(), person);
    }
}
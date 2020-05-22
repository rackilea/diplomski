class Person implements Comparable<Person> {
    private final int age;
    private final String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Age: %d, name: %s", age, name);
    }

    @Override
    public int compareTo(Person o) {
        return this.toString().compareTo(o.toString());
    }
}
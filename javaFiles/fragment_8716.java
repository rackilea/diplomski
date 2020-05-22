public class Person implements Comparable<Person> {
    // Existing class implementation

    @Override
    public int compareTo(Person p) {
        return p2.age - this.age;
    }
}
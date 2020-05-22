public class Person {}

public class Student extends Person implements Comparable<Person> {
    @Override public int compareTo(Person that) {
        // ...
    }
}
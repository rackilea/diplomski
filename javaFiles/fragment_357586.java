public class Person implements Comparable<Person> {
    private String name;
    private int age;

    @Override
    public int compareTo(Person o) {
       return this.name.compareTo(o.name);
    }
}
public class Student implements Comparable<Student> {

    String name;
    int age;
    String hobby;

    @Override
    public int compareTo(Student other) {
        final int nameComparison = name.compareToIgnoreCase(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Integer.compare(age, other.age);
    }

}
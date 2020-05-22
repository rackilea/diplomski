public class User implements Comparable<User> {
    // snipped...

    @Override
    public int compareTo (User other) {
        return Integer.compare(age, other.age);
    }
}
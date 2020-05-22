public class User implements Comparable<User> {
    private int id;

    // irrelevant code removed

    public User(int id) {
        this.id = id;
    }

    // irrelevant code removed

    public String toString() {
        return id + "";
    }

    @Override
    public int compareTo(User u) {
        return id - u.id;
    }
}
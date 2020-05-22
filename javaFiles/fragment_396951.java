import java.util.HashSet;

public class MyHashSet<Key> extends HashSet<Key> {

    private int limit;

    public MyHashSet(int limit) {
        super();
        this.limit = limit;
    }

    public boolean add(Key key) {
        if (!contains(key) && size() == limit) {
            throw new IndexOutOfBoundsException("Limit exceeded.");
        } else {
            return super.add(key);
        }
    }

    public static void main(String[] args) {
        HashSet<Integer> set = new MyHashSet<Integer>(1);
        set.add(0);
        set.add(1);  // IndexOutOfBoundsException
    }
}
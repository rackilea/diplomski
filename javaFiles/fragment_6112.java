public class Key implements Comparable<Key> {
    int c1, c2, c3;

    private static final int c2_min = Integer.MIN_VALUE;
    private static final int c2_max = Integer.MAX_VALUE;
    private static final int c3_min = Integer.MIN_VALUE;
    private static final int c3_max = Integer.MAX_VALUE;

    @Override
    public int compareTo(Key o) {
        if (c1!=o.c1) return Integer.compare(c1, o.c1);
        if (c2!=o.c2) return Integer.compare(c2, o.c2);
        return Integer.compare(c3, o.c3);
    }

    // constructor, equals, ...

}
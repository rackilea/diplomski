class Pair<A, C extends Comparable<C>> implements Comparable<Pair<A,C>> {
    public final A a;
    public final C c;

    Pair(A a, C c) {
        this.a = a;
        this.c = c;
    }

    @Override
    public int compareTo(Pair<A, C> o) {
        return c.compareTo(o.c);
    }
}
public class Triple<L, K, V> {

    private final L first;
    private final K second;
    private final V third;

    public Triple(L first, K second, V third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public L getFirst() {
        return this.first;
    }

    public K getSecond() {
        return this.second;
    }

    public V getThird() {
        return this.third;
    }

}
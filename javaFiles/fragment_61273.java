public class Pair<T1, T2> {
    // Instance Fields
    private T1 first;
    private T2 second;

    // Constructors
    public Pair() {}

    public Pair(Pair<? extends T1, ? extends T2> p) {
        first  = p.first;
        second = p.second;
    }
}
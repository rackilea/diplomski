public class FlexInterval<T extends Temporal & Comparable<T>> {

    private final T from;
    private final T to;

    public FlexInterval(T from, T to) {
        super();
        this.from = from;
        this.to = to;
    }

    public boolean contains(T test) {
        return (this.from.compareTo(test) <= 0) && (this.to.compareTo(test) >= 0);
    }
}
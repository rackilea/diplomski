public interface WithPriority extends Comparable<WithPriority> {
    int priority();
    @Override
    default int compareTo(WithPriority o) {
        // Reverse comparison so higher priority comes first.
        return Integer.compare(o.priority(), priority());
    }
}

public class PrioritySupplier<T> implements Supplier<T>, WithPriority {
    private final int priority;
    private final Supplier<T> supplier;
    public PrioritySupplier(int priority, Supplier<T> supplier) {
        this.priority = priority;
        this.supplier = supplier;
    }
    @Override
    public T get() {
        return supplier.get();
    }
    @Override
    public int priority() {
        return priority;
    }
}
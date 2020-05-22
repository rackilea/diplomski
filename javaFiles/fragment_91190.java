public abstract class Hierarchy<T> {
    private T parent;
    private Set<T> children;

    public static <E extends Hierarchy<E>> E getRoot(E x) {
        while (x.parent != null) {
            x = x.parent;
        }
        return x;
    }
}
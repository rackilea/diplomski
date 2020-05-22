// The list interface
interface List<T extends Comparable<T>> {

    boolean isEmpty();

    T first();

    List<T> rest();
}

// Instances of this class represents an empty list: ()
class Empty<T extends Comparable<T>> implements List<T> {

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public T first() {
        return null;
    }

    @Override
    public List<T> rest() {
        return null;
    }

    @Override
    public String toString() {
        return "()";
    }
}

// A non-empty list, composed of the first element and the rest.
class Cons<T extends Comparable<T>> implements List<T> {

    private final T first;
    private final List<T> rest;

    public Cons(T first, List<T> rest) {
        this.first = first;
        this.rest = rest;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T first() {
        return first;
    }

    @Override
    public List<T> rest() {
        return rest;
    }

    @Override
    public String toString() {
        return "(" + first +", " + rest + ")";
    }
}

public class Lisp {

    // Creates and returns a sorted list from the given list
    // The original list is never changed.
    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        if (list.isEmpty()) {
            // Empty lists are already sorted.
            return list;
        } else {
            // We first sort the rest of the list
            List<T> sortedRest = sort(list.rest());
            // Then insert the first element into the sorted list
            return insert(list.first(), sortedRest);
        }
    }

    // Creates and returns a sorted list with x inserted into a proper position in the already sorted list
    private static <T extends Comparable<T>> List<T> insert(T x, List<T> list) {
        if (list.isEmpty() || x.compareTo(list.first()) < 0) {
            return new Cons<>(x, list);
        } else {
            // Recursive call return a sorted list containing x
            return new Cons<>(list.first(),
                              insert(x, list.rest()));
        }
    }

    public static void main(String [] args) {
        List<Integer> alist = new Cons<>(7, new Cons<>(1, new Cons<>(4, new Empty<>())));
        System.out.println("Sorted:   " + sort(alist));
        System.out.println("Original: " + alist);
    }
}
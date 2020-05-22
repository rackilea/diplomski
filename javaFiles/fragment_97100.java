public class Node<T extends Comparable<T>> {
    public T value;

    public Node() {
    }

    public void testCompare(T anotherValue) {
        int cmp = value.compareTo(anotherValue);
        if (cmp == 0)
            System.out.println("equal");
        else if (cmp < 0)
            System.out.println("less");
        else if (cmp > 0)
            System.out.println("greater");
    }
}
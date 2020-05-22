public final class Box<T extends A & Comparable<T>> {
    private T item1;
    private T item2;

    int compare() {
        // this is the compare method of Comparable interface
        return item1.compareTo(item2);
    }
}
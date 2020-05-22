class Heap<T> extends ArrayList<T>   {
    private final Comparator<T> comparator;

    public Heap(Comparator<T> comparator) {
        this.comparator = comparator;
    }
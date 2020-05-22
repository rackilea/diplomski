public abstract class Heap<T extends Comparable<T>> {
    T data[];
    int count, size;

    public Heap(int size) {
        this.size = size;
        data = (T[]) new Comparable[size+1];
        this.count = 0;
    }

    public abstract void insert(T item);

}
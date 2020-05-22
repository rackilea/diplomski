class Swapable<T> {
    final T a;
    final T b;
    boolean useA = true;

    Swapable(T a, T b) {
        this.a = a;
        this.b = b;
    }

    T get() {
        return useA ? a : b;
    }

    void swap() {
        useA = !useA;
    }
}
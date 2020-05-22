class Array<T> {
    final Object[] data;

    public Array(int size) {
        data = new Object[size];
    }

    public void set(int index, T datum) {
        data[index] = datum;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) data[index];
    }
}
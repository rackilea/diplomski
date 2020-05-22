class ArrayList<E> {
    Object[] array = new Object[10];
    int size;

    void add(E value) {
        if(size >= array.length) {
            array = Arrays.copyOf(array, (int)(size * 3L / 2L));
        }

        array[size++] = value;
    }

    E get(int index) {
        return (E)array[index];
    }
}
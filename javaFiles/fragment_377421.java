class ArrayList<E> {
    Object[] array = new Object[some_length];
    public E get(int index) {
        return (E)array[index];
    }
}
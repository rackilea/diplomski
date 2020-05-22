class GenericClass<E> {
    private List<E> list = new ArrayList<E>();

    public void addAll(List<E> newList) {
        list.addAll(newList);
    }

    public void add(E e) {
        list.add(e);
    }

    public E get(int index) {
        return list.get(index);
    }
    // some other code
}
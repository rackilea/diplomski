static class JSLikeArray<E> extends ArrayList<E> {
    public JSLikeArray(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public E get(int index) {
        if (index >= size()) return null;

        return super.get(index);
    }

    @Override
    public E set(int index, E element) {
        int l = index + 1;
        for (int i = size(); i < l; i++) {
            add(null);
        }

        super.set(index, element);

        return element;
    }
}

public static void main(String[] args) {
    JSLikeArray<Integer> array = new JSLikeArray<Integer>(10);

    array.set(3, 3);

    System.out.println("array before add: " + array);
    System.out.println("array.get(10): " + array.get(10));
    array.add(4);
    System.out.println("array after add: " + array);
}
class Stack<E> {
    private Object[] elements;
    private int size;

    Stack(int len) {
        elements = new Object[len];
    }

    void push(E e) {
        elements[size] = e;
        size++;
    }

    E pop() {
       @SuppressWarnings("unchecked");
       E e = (E)elements[size - 1];
       size--;
       return e;
    }
}
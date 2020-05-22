class Stack<E> {
    protected E[] elements = (E[])new Object[1];
}

class IntStack extends Stack<Integer> {
    void push(Integer i) {
        // subtly accessing elements as Integer[] which it's not
        elements[0] = i;
    }
}
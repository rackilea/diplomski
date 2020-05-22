class StackArray<T> implements Stack<T> {
    private int maxSize;
    private Object[] array;
    private int top;

    public StackArray(int maxSize) {
        this.maxSize = maxSize;
        this.array = new Object[maxSize];
        this.top = -1;
    }

    // ... lines removed ...

    public T pop() {
        if(this.isEmpty())
            throw new EmptyStackException();
        return element(top--);
    }

    public T peek() {
        if(this.isEmpty())
            throw new EmptyStackException();
        return element(top);
    }

    // Safe because push(T) is type checked.
    @SuppressWarnings("unchecked")
    private T element(int index) {
        return (T)array[index];
    }
}
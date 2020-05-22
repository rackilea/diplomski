class Cell<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class IntWrapper {
    private int value;

    private int get() {
        return value;
    }

    private void set(int value) {
        this.value = value;
    }
}
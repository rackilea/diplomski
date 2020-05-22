class Holder<T> {
    private T instance;

    public Holder(T _instance) {
        instance = _instance;
    }

    public String toString() {
        return instance.toString();
    }
}
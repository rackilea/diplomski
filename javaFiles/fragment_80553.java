class HashEquivalenceKey<T> {
    private final T object;

    public HashEquivalenceKey(T object) {
        this.object = object;
    }

    public int hashCode() {
        return ((o == null) ? 0 : object.hashCode());
    }

    public boolean equals(Object o) {
        return ((o != null) && (this.hashCode() == o.hashCode()));
    }
}
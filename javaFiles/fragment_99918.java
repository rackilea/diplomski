class CollectionHolder<T> {
    private Collection<T> collection;

    public CollectionHolder(Collection<T> _collection) {
        collection= _collection;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(T t : collection) {
            builder.append(t); //same as builder.append(t.toString())
        }
        return builder.toString();
    }
}
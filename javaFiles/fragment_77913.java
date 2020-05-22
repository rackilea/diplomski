public Collection<V> values() {
    Collection<V> vs;
    return (vs = values) == null ? (values = new Values()) : vs;
}

final class Values extends AbstractCollection<V> {
    public final int size()                 { return size; }
    public final void clear()               { HashMap.this.clear(); }
    ...
}
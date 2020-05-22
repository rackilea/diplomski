public <T extends GameObject, V> List<V> enumValues(List<T> list, ValueGetter<T, V> reader) {
    List<V> vals = new ArrayList();

    for(T o : list) {
        vals.add(reader.getValue(o));
    }
    return vals;
}
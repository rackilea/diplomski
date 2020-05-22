@Override
public <Key extends Index> boolean putAll(Multimap<Key, ? extends V> multimap) {
    for (Key index : multimap.keySet()) {
        putAll(index, multimap.get(index));
    }
}
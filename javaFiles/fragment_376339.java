Map<K,V> m = (Map<K,V>) o;
if (m.size() != size())
    return false;

Iterator<Entry<K,V>> i = entrySet().iterator();
while (i.hasNext()) {
Entry<K,V> e = i.next();
K key = e.getKey();
V value = e.getValue();
if (value == null) {
    if (!(m.get(key)==null && m.containsKey(key)))
        return false;
} else {
    if (!value.equals(m.get(key)))
        return false;
}
return true;
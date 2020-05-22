public void put(K key, V value) {
    int keyBucket = hash(key);

    MapEntry<K, V> temp = Hash[keyBucket];
    while (temp != null) {
        if ((temp.key == null && key == null)
                || (temp.key != null && temp.key.equals(key))) {
            temp.value = value;
            return;
        }
        temp = temp.next;
    }

    final MapEntry<K, V> newEntry = new MapEntry<K, V>(key, value);
    newEntry.next = Hash[keyBucket]; // chain with current entry
    Hash[keyBucket] = newEntry;
    size++;
}
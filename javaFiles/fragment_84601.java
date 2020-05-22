class HashTable<K, V> {
    static class Entry<K, V> {
        K key;
        V value;

        Entry<K, V> next;

        Entry(K key, V value) {
           this.key = key;
           this.value = value;
        }
    }

    Entry[] table = new Entry[8];
    int size;

    void put(K key, V value) {
        Entry<K, V> entry = table[indexFor(key)];
        while(entry != null) {
            if(entry.key.equals(key)) {
                entry.value = value;
                return;
            }

            entry = entry.next;
        }

        resizeIfNeeded();

        addEntry(new Entry<K, V>(key, value));
        size++;
    }

    void addEntry(Entry<K, V> newEntry) {
        int index = indexFor(newEntry.key);
        Entry<K, V> entry = table[index];

        if(entry == null) {
            table[index] = newEntry;

        } else {
            while(entry.next != null)
                entry = entry.next;

            entry.next = newEntry;
        }
    }

    void resizeIfNeeded() {
        if(size < table.length)
            return;

        Entry[] old = table;
        table = new Entry[old.length << 1];

        for(Entry<K, V> entry : old) {
            while(entry != null) {
                addEntry(entry);
                Entry<K, V> next = entry.next;
                entry.next = null;
                entry = next;
            }
        }
    }

    V get(K key) {
        Entry<K, V> entry = table[indexFor(key)];
        while(entry != null) {
            if(entry.key.equals(key))
                return entry.value;

            entry = entry.next;
        }

        return null;
    }

    int indexFor(K key) {
        return key.hashCode() & table.length - 1;
    }
}
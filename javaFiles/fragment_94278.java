private abstract class HashIterator<E> implements Iterator<E> {
    Entry<K,V> next;    // next entry to return
    int expectedModCount;   // For fast-fail
    int index;      // current slot
    Entry<K,V> current; // current entry

    HashIterator() {
        expectedModCount = modCount;
        if (size > 0) { // advance to first entry
            Entry[] t = table;
            while (index < t.length && (next = t[index++]) == null)
                ;
        }
    }

    final Entry<K,V> nextEntry() {
        if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
        Entry<K,V> e = next;
        if (e == null)
            throw new NoSuchElementException();

        if ((next = e.next) == null) {
            Entry[] t = table;
            while (index < t.length && (next = t[index++]) == null)
                ;
        }
    current = e;
        return e;
    }

    // ...
}
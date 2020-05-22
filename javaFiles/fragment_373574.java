/**
 * Returns the key corresponding to the specified Entry.
 * @throws NoSuchElementException if the Entry is null
 */
static <K> K key(Entry<K,?> e) {
    if (e==null)
        throw new NoSuchElementException();
    return e.key;
}
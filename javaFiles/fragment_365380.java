abstract class HashIterator {
    ...
    public void remove() {
        if (lastReturned == null)
            throw new IllegalStateException();
        ConcurrentHashMap.this.remove(lastReturned.key);
        lastReturned = null;
    }
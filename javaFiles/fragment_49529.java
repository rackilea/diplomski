public boolean add(E element, BooleanSupplier availability) {
    lock.lock();
    try {
        if (data.putIfAbsent(element, availability) == null) {
            notEmpty.signal();
            return true;
        }
        return false;
    } finally {
        lock.unlock();
    }
}
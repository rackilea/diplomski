public int getCurrentCount {
    while (true) {
        int current = counter.get();
        int next = (current+1) % 8;
        if (counter.compareAndSet(current, next))) return next;
    }
}
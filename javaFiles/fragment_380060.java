public void anotherLock() {
    synchronized(m) {
        // Should handle another shared resource
        // otherwise you might get unexpected results
    }
}
private final Object splitLock = new Object();

// Use it like this ...
synchronized (splitLock) {
    split();
}
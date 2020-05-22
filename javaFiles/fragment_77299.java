private final AtomicIntegerArray ints = new AtomicIntegerArray(KNOWN_SIZE);
[...]
    int len = ints.length();
    for (int i=0; i<len; ++i) {
        ints.addAndGet(i, value);
    }
}
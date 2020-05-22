public Heap() {
    this(100);
}

public Heap(int maximumSize) {
    if (maximumSize < 1) {
        throw new IllegalArgumentException(
            String.format("invalid maximumSize: %d", maximumSize));
    }
    this.maximumSize = maximumSize;
    data = new int[this.maximumSize];
}
private volatile int value;

public final int get() {
    return value;
}

public int intValue() {
    return get();
}
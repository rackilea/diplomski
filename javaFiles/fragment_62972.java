private final E[] a; // This is internal array of List

ArrayList(E[] array) {
    a = Objects.requireNonNull(array);
}

public static <T> T requireNonNull(T obj) {
    if (obj == null)
        throw new NullPointerException();
    return obj; // Just return the array reference. No deep copy
}
public IntegerArray merge(IntegerArray other) {
    int[] newA = new int[a.length + other.a.length];
    for (int i = 0; i < a.length; i++) {
        newA[i] = a[i];
    }
    for (int i = 0; i < other.a.length; i++) {
        // here is where you need to be careful about the index
        newA[i + a.length] = other.a[i];
    }
    return new IntegerArray(newA);
}
private static final long factorial (int i) {
    if (i == 0) {
        return 1L;
    }
    return i * factorial(i - 1);
}
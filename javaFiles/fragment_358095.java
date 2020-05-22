public int square(int x) {
    if (x % 2 == 0) {
        return x * x;
    } else {
        throw new IllegalArgumentException("Cannot square odd numbers");
    }
}
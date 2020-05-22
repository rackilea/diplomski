public int square(int x) {
    if (x % 2 == 1) {
        return x * x;
    } else {
        throw new IllegalArgumentException("Cannot square even numbers");
    }
}
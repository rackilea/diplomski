public int square(int x) {
    if (x % 2 == 0) {
        return x * x;
    } else {
        // Even this is binary compatible (although bad form as the method
        // name is no longer self-explanatory.)
        return x * x * x;
    }
}
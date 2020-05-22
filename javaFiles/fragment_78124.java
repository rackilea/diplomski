public long getSummation(long n) {
    if(n < 0) {
        throw new IllegalArgumentException("Values below 0 are not supported.");
    }
    if(n == 0) {
        return 0;
    } else {
        return n + getSummation(n - 1);
    }
}
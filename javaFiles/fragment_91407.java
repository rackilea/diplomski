public boolean doesContain(double x) {
    if (left >= right) {
        return false;
    } else {
        return x >= left && x <= right;
    }
}
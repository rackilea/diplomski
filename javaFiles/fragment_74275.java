int candy(int n, int m) {
    if ((n <= 1) || (m == 0)) {
        return 0;
    }
    return n/m + candy( ((n+n%m)/m), m);
}
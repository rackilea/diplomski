static int[] fact(int n) {
    int[] r = new int[100];
    r[0] = 1;
    for (int i = 1; i <= n; ++i) {
        int carry = 0;
        for (int j = 0; j < r.length; ++j) {
            int x = r[j] * i + carry;
            r[j] = x % 10;
            carry = x / 10;
        }
    }
    return r;
}
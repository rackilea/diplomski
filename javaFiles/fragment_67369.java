int findMax(int c[]) {
    int max = c[0];
    int max_i = 0;
    for (int i = 1; i < c.length; i++) {
        if (c[i] > max) {
            max = c[i];
            max_i = i;
        }
    }
    return max_i;
}
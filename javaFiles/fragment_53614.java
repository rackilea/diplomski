public boolean oddsMatchEvens(int[] w, int[] q) {
    int count = 0;
    for (int i = 0; i < w.length; i++) {
        if (w[i] == q[i + 1]) {
            count++;
            if (count == w.length) {
                return true;
            }
        }
    }

    return false;
}
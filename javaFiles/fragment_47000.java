int answer = -1;
for (int k = 1;; k++) {
    int i = target / k - k + 1;
    if (i <= 0) {
        break;
    }
    // Check if calculated i, can be the start of 'odd' sequence.
    if (target % k == 0 && i % 2 == 1) {
        answer = k;
    }
}
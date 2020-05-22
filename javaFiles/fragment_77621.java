double sum = 0;
for (double n = 1; ; n++) {
    double term = 1 / (n * n);
    sum += term;
    if (Math.abs(term) <= 1e-12 * Math.abs(sum)) {
        break;
    }
}
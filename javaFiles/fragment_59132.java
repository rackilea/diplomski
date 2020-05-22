while (n != 1) {
    if (n % 2 == 0) {
        n = n / 2;
    } else {
        if (n > (Integer.MAX_VALUE - 1) / 3) {
            throw new RuntimeException("overflow!");
        }
        n = 3 * n + 1;
    }
    counter++;
}
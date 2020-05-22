while (n != 1) {
    if (n % 2 == 0) {
        n = n / 2;
    } else {
        n = Math.addExact(Math.multiplyExact(3, n), 1);
    }
    counter++;
}
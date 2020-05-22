for (long i = 2; i < array.length; i++) {
    if (array[(int)i]) {
        long j = i * i;
        while (j < array.length) {
            array[(int)j] = false;
            j += i;
        }
    }
}
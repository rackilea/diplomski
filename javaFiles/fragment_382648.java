private static void decompose(final long l, final short[] array) {
    long q = l;
    long r = 0;
    for (int j=array.length-1; j >= 0; j--) {
        // compute remainder
        r = q % 1000;
        // compute quotient
        // converts to int and fractional part is dropped without rounding
        q = q / 1000;

        array[j] = (short) r;
    }
}
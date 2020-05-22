long[] div = new long[array.length];
long total = 1;
for (int i = array.length - 1; i >= 0; i--) {
    div[i] = total;
    if ((total *= array[i].length) <= 0)
        throw new IllegalStateException("Overflow or empty sublist");
}
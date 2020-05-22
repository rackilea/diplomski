private static int toBits(boolean[] array) {
    if (array.length > 32)
        throw new IllegalArgumentException("Array too large: " + array.length);
    int bits = 0;
    for (int i = 0; i < array.length; i++)
        if (array[i])
            bits |= 1 << i;
    return bits;
}
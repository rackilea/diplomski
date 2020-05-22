public int[] foo(final int[] values, final int[] sizes) {
    final int[] results = new int[sizes.length];
    int         index  = 0;

    for (int i = 0; i < sizes.length; i++) {
        if (index > values.length)
            break;

        results[i]  = values[index];
        index     += sizes[i];
    }

    return results;
}
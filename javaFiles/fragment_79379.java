/**
     * Compares this string to the given string.
     *
     * <p>The strings are compared one {@code char} at a time.
     * In the discussion of the return value below, note that {@code char} does not
     * mean code point, though this should only be visible for surrogate pairs.
     *
     * <p>If there is an index at which the two strings differ, the result is
     * the difference between the two {@code char}s at the lowest such index.
     * If not, but the lengths of the strings differ, the result is the difference
     * between the two strings' lengths.
     * If the strings are the same length and every {@code char} is the same, the result is 0.
     *
     * @throws NullPointerException
     *             if {@code string} is {@code null}.
     */
    public native int compareTo(String string);
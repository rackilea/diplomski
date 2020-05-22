/**
 * Generate a range of {@code Integer}s as a {@code Stream<Integer>} including
 * the left border and excluding the right border.
 * 
 * @param fromInclusive left border, included
 * @param toExclusive   right border, excluded
 * @param step          the step, can be negative
 * @return the range
 */
public static Stream<Integer> rangeStream(int fromInclusive,
        int toExclusive, int step) {
    // If the step is negative, we generate the stream by reverting all operations.
    // For this we use the sign of the step.
    int sign = step < 0 ? -1 : 1;
    return IntStream.range(sign * fromInclusive, sign * toExclusive)
            .filter(i -> (i - sign * fromInclusive) % (sign * step) == 0)
            .map(i -> sign * i)
            .boxed();
}
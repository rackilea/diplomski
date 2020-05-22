/**
 * @param first  the first duration
 * @param second the second duration
 * @return {@code first / second}
 * @throws IllegalArgument of {@code first}, {@code second} are negative or if {@code second} is zero
 */
public static long divide(Duration first, Duration second)
{
    if (first.isNegative())
      throw new IllegalArgumentException("first may not be negative");
    if (second.isNegative())
      throw new IllegalArgumentException("second may not be negative");
    if (second.isZero())
      throw new IllegalArgumentException("second may not be zero");
    BigDecimal firstDecimal = toSeconds(first);
    BigDecimal secondDecimal = toSeconds(second);
    return firstDecimal.divideToIntegralValue(secondDecimal).longValueExact();
}

/**
 * @param duration a duration
 * @return the number of seconds in the duration
 */
public static BigDecimal toSeconds(Duration duration)
{
    return BigDecimal.valueOf(duration.getSeconds()).add(BigDecimal.valueOf(duration.getNano(), 9));
}
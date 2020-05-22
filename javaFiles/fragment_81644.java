public static long sum(long min, long max, LongUnaryOperator mapper) {
    long result = 0;
    for (long i = min ; i <= max ; i++)
        result += mapper.applyAsLong(i);
    return result;
}
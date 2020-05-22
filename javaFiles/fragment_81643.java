public long sum(long min, long max) {
    long result = 0;
    for (int i = min ; i <= max ; i++)
        result += someOperation(i);
    return result;
}
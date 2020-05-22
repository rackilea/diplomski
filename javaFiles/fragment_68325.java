public static int iterativeWatchCount(int n) {
    if (n < 0) {
        return 0;
    }
    int index = 0;
    int[] cache = new int[6];
    cache[cache.length - 1] = 1;
    int sum = 1;
    for (int i = 0; i < n; i++, index = (index + 1) % cache.length) {
        sum = cache[0] + cache[1] + cache[2] + cache[3] + cache[4] + cache[5];
        cache[index] = sum;
    }
    return sum;
}
static int watchCount(int distance, Integer[] cache) {
    // Base cases
    if (distance < 0) {
        return 0;
    }
    if (distance == 0) {
        return 1;
    }
    if (cache[distance-1] == null) {
        cache[distance-1] = watchCount(distance - 1, cache)
                + watchCount(distance - 2, cache)
                + watchCount(distance - 3, cache)
                + watchCount(distance - 4, cache)
                + watchCount(distance - 5, cache)
                + watchCount(distance - 6, cache);
    }
    return cache[distance-1];
}
public float getPercentage(char c) {
    if (!map.containsKey(c))
        return 0;
    int sum = 0;
    for (Integer count : map.values())
        sum += count;
    return map.get(c) / (float)sum;
}
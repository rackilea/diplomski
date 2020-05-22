int[] tps(int tps) {
    int[] sleepTimes = new int[tps];
    int low = 1000 / tps; // the floored value
    Arrays.fill(sleepTimes, low);
    int mod = 1000 % tps; // number of ceiled values to insert
    if (mod > 0) {
        int high = low + 1; // the ceiled value
        float rate = tps / (float) mod; // the insertion rate
        for (int i = 0; i < mod; i++) {
            sleepTimes[Math.round(i * rate)] = high;
        }
    }
    return sleepTimes;
}
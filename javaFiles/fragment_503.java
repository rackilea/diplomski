int[] tps(int tps) {
    int[] sleepTimes = new int[tps];
    for (int i = 0, remainder = 1000; i < tps; i++) {
        int sleepTime = remainder / (tps - i);
        sleepTimes[i] = sleepTime;
        remainder -= sleepTime;
    }
    return sleepTimes;
}
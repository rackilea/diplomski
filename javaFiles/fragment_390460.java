public void runAlgorithm () {
    for (int i=startKey; i<endKey; i++) {
        String key = toBase26(i);
        testKey(key);
    }
}
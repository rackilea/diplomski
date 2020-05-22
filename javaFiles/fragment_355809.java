public static int mostOccurances(double[] input) {
    Map<Double, Integer> map = new HashMap<>();

    // Go over the input and store in map
    for (double d : input) {
        Integer count = map.get(d);
        if (count == null) {
            map.put (d, 1);
        } else {
            map.put (d, count + 1);
        }
    }

    // Go over the map and return the maximum occurrence
    // assumption: if input is empty, it's OK to return 0
    int retVal = 0;
    for (int count : map.values()) {
        retVal = Math.max(retVal, count);
    }

    return retVal;
}
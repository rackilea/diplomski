private String getMinKey(Map<String, Integer> map, String... keys) {
    String minKey = null;
    int minValue = Integer.MAX_VALUE;
    for(String key : keys) {
        int value = map.get(key);
        if(value < minValue) {
            minValue = value;
            minKey = key;
        }
    }
    return minKey;
}
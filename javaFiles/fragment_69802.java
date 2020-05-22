public static Map<Integer, Integer> countOccurences (int[] arr) {
    int len = arr.length;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    for(int i = 0; i < len; i++) {
        int key = arr[i];
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.put(key, value + 1);
        } else {
            map.put(key, 1);
        }
    }

    return map;
}
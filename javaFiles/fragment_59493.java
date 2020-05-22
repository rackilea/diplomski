public static List<Integer> getResultListByMap(List<List<Integer>> inputList, int k) {
    Map<Integer, Integer> times = new HashMap<>();
    for (List<Integer> integers : inputList) {
        for (Integer integer : integers) {
            if (times.keySet().contains(integer)) {
                times.put(integer, times.get(integer) + 1);
            } else {
                times.put(integer, 1);
            }
        }
    }

    List<Integer> result = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : times.entrySet()) {
        if (entry.getValue() >= k) {
            result.add(entry.getKey());
        }
    }
    return result;
}
public static List<Integer> getResultListBySort(List<List<Integer>> inputList, int k) {
    List<Integer> newList = inputList.parallelStream()
            .flatMap(l -> l.parallelStream()).sorted().collect(Collectors.toList());

    List<Integer> result = new ArrayList<>();

    Integer prev = null;
    int sum = newList.get(0);
    for (Integer integer : newList) {
        if (integer.equals(prev)) {
            sum++;
        } else {
            if (sum >= k) {
                result.add(integer);
            }
            sum = 1;
        }
        prev = integer;
    }
    return result;
}
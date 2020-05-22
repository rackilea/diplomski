public static List<Integer> getPrice(List<Integer> list) {
    Set<Integer> aSet = new HashSet<Integer>();
    for (Integer number : list) {
        if (Collections.frequency(list, number) > 3) {
            aSet.add(number);
        }
    }
    List<Integer> result = new ArrayList<Integer>();
    result.addAll(aSet);
    return result;
}
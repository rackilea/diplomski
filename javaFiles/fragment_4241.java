public static List<Integer> getIntEight(List<Integer> list) {
    List<Integer> res = list.stream()
            .filter(i -> i.equals(8))
            .collect(Collectors.toList());
    list.removeAll(res);
    return res;
}
public static <T, U> List<Pair<T, U>> cartesianProduct(List<T> list1, List<U> list2) {
    List<Pair<T, U>> result = new ArrayList<>();
    for (T el1: list1) {
        for (U el2 : list2) {
            result.add(Pair.of(el1, el2));
        }
    }
    return result;
}
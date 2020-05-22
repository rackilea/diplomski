public static <T,R> List<T> transformedList(List<T> inList, Function<T, R> f) {
    List<R> outList = new ArrayList<>();
    for (T s : inList) {
        outList.add(f.apply(s));
    }
    return outList;
}
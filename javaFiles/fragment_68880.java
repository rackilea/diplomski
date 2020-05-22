private static <T, S> List<S> makeList(List<T> list, Function<T, S> fn) {
    ArrayList<String> result = new ArrayList<>();
    for (T t : list) {
        result.add(fn.apply(t));
    }
    return result;
}
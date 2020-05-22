List<String> ls = new ArrayList<>();
List<Integer> li = new ArrayList<>();

public static <T> List<T> copy(Collection<T> list) {
    List<T> result = new ArrayList<>();
    result.addAll(list);
    return result;
}

public List<String> getLS() {
    return copy(ls);
}

public List<Integer> getLI() {
    return copy(li);
}
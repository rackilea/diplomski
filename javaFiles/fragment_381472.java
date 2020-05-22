@SuppressWarnings("unchecked")
public static <T> List<List<T>> combos(int len, List<T> list) {
    if (len <= 0 || len > list.size())
        throw new IllegalArgumentException();
    List<List<T>> result = new ArrayList<>();
    combos(list, 0, Arrays.asList((T[])new Object[len]), 0, result);
    return result;
}
private static <T> void combos(List<T> list, int listIdx, List<T> values, int valueIdx, List<List<T>> result) {
    if (valueIdx == values.size()) {
        result.add(new ArrayList<>(values));
        return;
    }
    int lastIdx = list.size() - (values.size() - valueIdx);
    for (int i = listIdx; i <= lastIdx; i++) {
        values.set(valueIdx, list.get(i));
        combos(list, i + 1, values, valueIdx + 1, result);
    }
}
public static <T> List<List<T>> combos(List<List<T>> list1, List<List<T>> list2) {
    List<List<T>> result = new ArrayList<>(list1.size() * list2.size());
    for (List<T> value1 : list1)
        for (List<T> value2 : list2) {
            List<T> combo = new ArrayList<>(value1.size() + value2.size());
            combo.addAll(value1);
            combo.addAll(value2);
            result.add(combo);
        }
    return result;
}
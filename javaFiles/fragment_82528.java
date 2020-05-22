public static void multiply(List<?> list, int n) {
    if (n == 0) {
        list.clear();
        return;
    }
    @SuppressWarnings("unchecked")
    List<Object> oldSchool = (List<Object>) list;
    List<?> copy = new ArrayList<>(list);
    for (int i = 1; i < n; i++) {
        oldSchool.addAll(copy);
    }
}
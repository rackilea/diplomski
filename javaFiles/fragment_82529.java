public static <T> void multiply(List<T> list, int n) {
    List<T> copy = new ArrayList<>();

    if (n == 0) {
        list.clear();
    }

    for (int i = 1; i <= n; i++) {
        copy.addAll(list);
    }

    list.clear();
    list.addAll(copy); // this is now OK
}
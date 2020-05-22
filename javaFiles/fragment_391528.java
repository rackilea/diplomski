public static void swapFirstAndLast(List<?> list) {
    helper(list);
}

private static <E> void helper(List<E> list) {
    int size = list.size();
    E e = list.get(0);
    list.set(0, list.get(size - 1)); // These lines would not be possible
    list.set(size - 1, e);           // If the type of list were List<?>
}
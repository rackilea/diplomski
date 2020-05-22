public static <E> boolean containsInstance(List<E> list, Class<? extends E> clazz) {
    for (E e : list) {
        if (clazz.isInstance(e)) {
            return true;
        }
    }
    return false;
}
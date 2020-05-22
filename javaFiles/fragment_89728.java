static <E> List<E> test(Map<?, List<E>> m) {
    List<E> result = new ArrayList<E>();

    for(List<E> value : m.values()) {
        result.addAll(value);
    }

    return result;
}
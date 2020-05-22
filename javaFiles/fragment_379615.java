/** Like Collectors.groupingBy, but accepts null keys. */
public static <T, A> Collector<T, ?, Map<A, List<T>>>
groupingBy_WithNullKeys(Function<? super T, ? extends A> classifier) {
    return Collectors.toMap(
        classifier,
        Collections::singletonList,
        (List<T> oldList, List<T> newEl) -> {
            List<T> newList = new ArrayList<>(oldList.size() + 1);
            newList.addAll(oldList);
            newList.addAll(newEl);
            return newList;
            });
    }
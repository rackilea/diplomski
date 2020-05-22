public static <T> void merge(List<T> listA, List<T> listB, BiPredicate<T, T> areEqual) {
    listA.addAll(listB.stream()
                      .filter(t -> listA.stream().noneMatch(u -> areEqual.test(t, u)))
                      .collect(Collectors.toList())
    );
}
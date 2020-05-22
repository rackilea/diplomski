private static Map<String, Integer> countBooksByTitle(List<Book> list1, List<Book> list2) {
    Collator collator = Collator.getInstance(Locale.US);
    collator.setStrength(Collator.PRIMARY);
    return Stream.concat(list1.stream(), list2.stream())
            .collect(Collectors.groupingBy(book -> new PurifiedTitle(book.getTitle()),
                                           Collectors.counting()))
            .entrySet().stream()
            .collect(Collectors.toMap(e -> e.getKey().toString(),
                                      e -> e.getValue().intValue(),
                                      Integer::sum,
                                      () -> new TreeMap<>(collator)));
}
public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
    System.out.println("inside distinctByKey method...");
    Set<Object> seen = ConcurrentHashMap.newKeySet();
    return t -> {
        System.out.println("inside distinctByKey.lambda method... ");
        return seen.add(keyExtractor.apply(t));
    };
}
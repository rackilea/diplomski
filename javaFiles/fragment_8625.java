public static <T> Predicate<T> distinctByKey(Function<? super T,Object> keyExtractor) {
    Map<Object,Boolean> seen = new ConcurrentHashMap<>();
    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
}

Stream s = StreamSupport.stream(registrations.spliterator(), false);
s.filter(distinctByKey((Registration r) -> r.getEntry().getUuid())).collect(Collectors.toList());
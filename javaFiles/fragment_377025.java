private Set<Long> getAllIds(List<MyClass> fetchedElements,
        List<Function<MyClass, Long>> extractors) {
    return fetchedElements.stream()
            .flatMap(item -> extractors.stream().map(f -> f.apply(item)))
            .collect(Collectors.toSet());
}
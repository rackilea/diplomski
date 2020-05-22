private Map<String, Object> getFinalMap(final Map<String, Object> inputMap) {
    return inputMap.entrySet()
        .stream()
        .filter(e -> !(e.getValue() instanceof Collection && ((Collection) e.getValue()).isEmpty()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
}
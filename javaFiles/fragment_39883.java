private Map<String, Object> getFinalMap(final Map<String, Object> inputMap) {
    final Map<String, Object> resultMap = new HashMap<>(inputMap);
    resultMap.entrySet().removeIf(e -> e.getValue() instanceof Collection && ((Collection) e.getValue()).isEmpty());

    return resultMap;
}
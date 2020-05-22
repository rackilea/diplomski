private Map<String, String> mapConfig(Map<String, Integer> input, String prefix) {
    return input.entrySet().stream()
            .collect(Collectors.toMap(
                   entry -> entry.getKey().substring(subLength), 
                   entry -> AttributeType.GetByName(entry.getValue())));
}
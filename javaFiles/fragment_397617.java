@Override
public Map<String, Object> resolve(List<String> properties) {
    Map<String, Object> result = new HashMap<>();

    List<String> eligibleProperties = new ArrayList<>(properties);
    eligibleProperties.retainAll(extractors.keySet());

    if (!eligibleProperties.isEmpty()) {
        Data data = getData();
        for (String property : eligibleProperties) {
            result.put(property, extractors.get(property).extract(data));
        }
    }

    List<String> remainingProperties = new ArrayList<>(properties);
    remainingProperties.removeAll(eligibleProperties);

    if (!remainingProperties.isEmpty()) {
        result.putAll(successor.resolve(remainingProperties));
    }

    return result;
}
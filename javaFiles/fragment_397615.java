interface PropertyResolver {
    Map<String, Object> resolve(List<String> properties);
}

class UnknownResolver implements PropertyResolver {
    @Override
    public Map<String, Object> resolve(List<String> properties) {
        Map<String, Object> result = new HashMap<>();
        for (String property : properties) {
            result.put(property, "Unknown");
        }
        return result;
    }
}
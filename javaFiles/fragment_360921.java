List<String> stringValues = new ArrayList<String>();
for (Object value : map.values()) {
    if (value instanceof String) {
        stringValues.add((String) value);
    }
}
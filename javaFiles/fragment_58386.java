public void process() {
    Map<String, Object> target = null;
    Source source = null;
    Boolean value = addIfMatters(target, source, true);  // How can I avoid the cast on this line?
    if (value) {
        // I have some stuff to do here
    }
}

private <T> T addIfMatters(Map<String, Object> target, Source source, T defaultValue) {
    T value = null;
    if (needed(source)) {
        if (defaultValue instanceof Boolean) {
            value = convertToBoolean(source.getValue, defaultValue); // returns 'defaultValue' if value in source is null
        } else if (defaultValue instanceof Integer) {
            value = convertToInteger(source.getValue, defaultValue);
        }
}
    return value;
}
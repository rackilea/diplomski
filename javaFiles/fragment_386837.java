public <T> List<Map<String,Object>> getUIElementsList(T value) {
    if (value instanceof Class) { 
        throw new IllegalArgumentException("Class instances are not supported");
    }
    ..
}
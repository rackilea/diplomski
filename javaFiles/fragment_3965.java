public Type getType(String name) {
    try {
        Class<?> clazz = Class.forName(typeName);
        TypeToken<?> typeToken = TypeToken.get(clazz);
        return typeToken.getType();
    } catch (ClassNotFoundException e) {
        throw new IllegalArgumentException("Unsupported type: " + typeName, ce);
    }
}
private static class TransientExclusionStrategy implements ExclusionStrategy {
    public boolean shouldSkipClass(Class<?> clazz) {
        return (clazz.getModifiers() & java.lang.reflect.Modifier.TRANSIENT) != 0;
    }

    public boolean shouldSkipField(FieldAttributes f) {
        return f.hasModifier(java.lang.reflect.Modifier.TRANSIENT);
    }
}
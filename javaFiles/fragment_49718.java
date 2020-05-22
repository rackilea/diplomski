boolean isNameIgnored = false;
ExclusionStrategy strategy = new ExclusionStrategy() {
    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }

    @Override
    public boolean shouldSkipField(FieldAttributes field) {
        return isNameIgnored ? "name".equals(field.getName()) : false;
    }
};
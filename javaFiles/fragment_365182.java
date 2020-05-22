public void set(Object value) throws LoadException {
    ...  
    Class<?> type = this.value.getClass();
    DefaultProperty defaultProperty = type.getAnnotation(DefaultProperty.class);
    if (defaultProperty == null) {
        throw constructLoadException("Element does not define a default property.");
    }

    getProperties().put(defaultProperty.value(), value);
}
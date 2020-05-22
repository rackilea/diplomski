public <T> ObservableValue<T> getPropertyModel(String key) {
    if (key == null) {
        throw new NullPointerException();
    }
    return (ObservableValue<T>)get(key + BeanAdapter.PROPERTY_SUFFIX);
}
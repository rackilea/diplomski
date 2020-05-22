public class PropertyHolder {

    private final ImmutableMap<PropertyKey<?>, ?> storage;

    /**
     * Returns value for the key of the type extending-the-one-declared-in-the {@link PropertyKey}.
     * 
     * @param key {@link PropertyKey} instance.
     * @return Value of the type declared in the key.
     */
    @SuppressWarnings("unchecked")
    public <T extends Serializable> T get(PropertyKey<T> key) {
        return (T) storage.get(key);
    }

    /**
     * Adds key/value pair to the state and returns new 
     * {@link PropertyHolder} with this state.
     * 
     * @param key {@link PropertyKey} instance.
     * @param value Value of type specified in {@link PropertyKey}.
     * @return New {@link PropertyHolder} with updated state.
     */
    public <T> PropertyHolder put(PropertyKey<T> key, T value) {
        Preconditions.checkNotNull(key, "PropertyKey cannot be null");
        Preconditions.checkNotNull(value, "Value for key %s is null", 
                key);
        Preconditions.checkArgument(key.checkType(value), 
                "Property \"%s\" was given " 
                + "value of a wrong type \"%s\"", key, value);
        // Creates ImmutableMap.Builder with new key/value pair.
        return new PropertyHolder(filterOutKey(key)
                .put(key, value).build());
    }

    /**
     * Returns {@link Builder} with all the elements from the state except for the given ket.
     * 
     * @param key The key to remove.
     * @return {@link Builder} for further processing.
     */
    private <T> Builder<PropertyKey<? extends Serializable>, Serializable> filterOutKey(PropertyKey<T> key) {
        Builder<PropertyKey<? extends Serializable>, Serializable> builder = ImmutableMap
                .<PropertyKey<? extends Serializable>, Serializable> builder();
        for (Entry<PropertyKey<? extends Serializable>, Serializable> entry : this.storage.entrySet()) {
            if (!entry.getKey().equals(key)) {
                builder.put(entry);
            }
        }
        return builder;
    }

    ... rest of the class

}
public <T> void putFavorite(Class<T> type, T instance) {
    if (type == null)
        throw new NullPointerException("Type is null");
    if (!type.isInstance(instance)) // add check for instance type
        throw new IllegalArgumentException("Class/instance mismatch");
    favorites.put(type, instance);
}
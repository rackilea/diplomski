public <T> Collection<T> listenersOf(Class<T> type) {
    List<T> result = new ArrayList<T>();
    for (Object l : listeners) {
        if (type.isInstance(l)) result.add(type.cast(l));
    }
    return result;
}
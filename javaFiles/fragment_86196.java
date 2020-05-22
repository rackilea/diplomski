class Cache {
    private Map<Class<?>, Map<Long, ?>> items = new HashMap<Class<?>, Map<Long, ?>>();

    private <T> Map<Long, T> getItems(Class<T> type) {
        @SuppressWarnings("unchecked")
        Map<Long, T> result = (Map<Long, T>) items.get(type);
        if (result == null) {
            result = new HashMap<Long, T>();
            items.put(type, result);
        }
        return (Map<Long, T>) result;
    }

    public <T> void addItem(Class<T> type, Long id, T item) {
        getItems(type).put(id, item);
    }

    public <T> T getItem(Class<T> type, Long id) {
        return type.cast(getItems(type).get(id));
    }
}
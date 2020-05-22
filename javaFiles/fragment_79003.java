public final class Storage {

    private final Map<Class<?>, Set<?>> storage = new HashMap<>();

    public <T> Set<T> get(Class<T> s) {
        Set<T> result = (Set<T>) storage.get(s); // Unchecked cast
        if (result == null) {
            result = new HashSet<>();
            storage.put(s, result);
        }
        return result;
    }
}
public class ListenerManager {
    private final List<Object> listeners = new ArrayList<Object>();

    public <T> Collection<T> listenersOf(Class<T> type) {
        return listeners.stream()
            .filter(type::isInstance)
            .map(type::cast)
            .collect(Collectors.toList());
    }

    public void add(Object listener) {
        listeners.add(listener);
    }
}
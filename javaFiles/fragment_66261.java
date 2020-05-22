public class DynamicHandler {
    Map<Class, StaticHandler> handlers;

    public <T> void handle(T value) {
        if(value != null) {
            handlers.entrySet()
                    .stream()
                    .filter(entry -> 
                        entry.getKey().isInstance(value))
                    .findAny()
                    .ifPresent(entry ->
                        entry.getValue().handle(value));
        }
    }

    public void <T> register(StaticHandler<T> handler) {
        handlers.put(handler.getHandlingClass(), handler);
    }
}


interface StaticHandler<T>
{
    void handle(T value);
    Class<T> getHandlingClass();
}

public class StringHandler implements StaticHandler<String> {
    @Override public void handle(String value) {
        ...
    }
    @Override public final Class<String> getHandlingClass() {
        return String.class;
    }
}
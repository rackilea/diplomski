public <T> Handler<T> findHandler(Class<T> clazz) {
    Handler<?> handler = handlers.get(clazz);
    // Although the compiler can't assert it, the handler is of type T
    // The cast is safe, because we programmatically constrain map's entries
    return (Handler<T>)handler; // safe
}
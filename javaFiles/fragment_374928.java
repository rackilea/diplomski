Map<Class<T>, Handler<T>> registry = new HashMap<>();

public void registerHandler(Class<T> dataType, Class<? extends Handler> handlerType) {
    registry.put(dataType, handlerType);
}

public <T> Handler<T> getHandler(Class<T> clazz) {
  return registry.get(clazz).newInstance();
}
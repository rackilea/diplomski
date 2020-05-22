public void fireEvent(String name, Object... args) {
    Method method = null;
    // 1. find method
    for (Method m : EventListener.class.getMethods()) {
        if (m.getName().equals(name)) {
            method = m;
            break;
        }
    }

    if (method == null) {
        throw new IllegalArgumentException("Unknown event method: " + name);
    }

    // 2. call method on all listeners
    for (EventListener l : listeners) {
        try {
            method.invoke(l, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
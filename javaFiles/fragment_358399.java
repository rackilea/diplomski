@Provides
Listener listener(Colaborator test, Collection<Listener> listeners) {
    Listener newListener = new Listener(test);
    listeners.register(newListener);
    return listener;
}
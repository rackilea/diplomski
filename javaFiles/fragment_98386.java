class SubscriberList<E> extends CopyOnWriteArrayList<E> {
    final Class<E> eventClass;

    public void trigger(Object event) {
        E event = eventClass.cast(event);
        for (IEventSubscriber<E> subscriber : this) {
            subscriber.trigger(event);
        }
    }
}
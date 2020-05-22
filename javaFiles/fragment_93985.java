protected abstract Class<E> getEventClass();

public boolean acceptsEvent(Object event) // or an appropriate class for event
{
    return getEventClass().isAssignableFrom(event.getClass());
}
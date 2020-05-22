private HashMap<RequestType, LinkedList<IRequestListener<?>>> requestListenerMap = 
    new HashMap<RequestType, LinkedList<IRequestListener<?>>>();

...

LinkedList<IRequestListener<?>> listeners = 
    requestListenerMap.get(RequestType.NOTIFICATION);
for (IRequestListener<?> listener : listeners) {
    // Note that this cast is unsafe.
    IRequestListener<? extends Notification> notificationListener = 
        (IRequestListener<? extends Notification>) listener;
    notificationListener.resultUpdated(notification);
}
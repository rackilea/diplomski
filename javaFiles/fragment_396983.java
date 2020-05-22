private HashMap<RequestType, LinkedList<IRequestListener<? extends Notification>>> 
    requestListenerMap = new HashMap<>(); // Assuming Java 7

...

LinkedList<IRequestListener<? extends Notification>> listeners = 
    requestListenerMap.get(RequestType.NOTIFICATION);
for(IRequestListener<? extends Notification> listener : listeners) {
    listener.resultUpdated(notification);
}
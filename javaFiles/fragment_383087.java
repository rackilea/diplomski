public static PNode getRealEventSource(PInputEvent event, PInputEventListener listener) {
    PNode node = event.getPickedNode();
    while(node != null){
        EventListenerList listeners = node.getListenerList();
        if (listeners != null) {
            if (Arrays.asList(listeners.getListenerList()).contains(listener)) {
                return node;
            }
        }
        node = node.getParent();
    }

    return null;
}
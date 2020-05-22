interface InternalEventCallback {
    void run();
}

class InternalEventCallbackHandler {

    @Subscribe
    public void internalEventHandler(InternalEventCallback r){
        r.run();
    }
}
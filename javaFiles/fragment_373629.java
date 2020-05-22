public void onReceive(Object message) throws Exception {
    final ActorRef senderActorRef = getSender(); //never close over a future
    if (message instanceof String) {
        Future<String> f = // ...
        f.onSuccess(new OnSuccessExtension(senderActorRef), ex);
    }
}

private final class OnSuccessExtension extends OnSuccess {
    private final ActorRef senderActorRef;

    public OnSuccessExtension(ActorRef senderActorRef) {
        this.senderActorRef = senderActorRef;
    }

    @Override
    public void onSuccess(Object arg0) throws Throwable {
        log.info("what");
        // use senderActorRef
    }
}
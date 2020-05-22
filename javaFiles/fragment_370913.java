Consumer<? super MessageReceivedEvent> callback;

private void onInput(Consumer<? super MessageReceivedEvent> callback) {
    this.callback = callback;
}

@Override
public void onMessageReceived(MessageReceivedEvent event) {
    if (this.callback != null)
        this.callback.accept(event);
    this.callback = null;
}
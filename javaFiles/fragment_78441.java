private Consumer<SocketConversation> callback;

public SocketConversation(URI uri, int idx, String line, long delay, Consumer<SocketConversation> callback) {
    this.callback = callback;
    ...
}
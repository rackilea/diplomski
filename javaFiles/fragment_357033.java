private CompletableFuture<Boolean> matchingMessage;
private String identifier;

@Override
protected void receive(Incident message) {
    if (omsIdentifier == null) {
        return;
    }

    if (matches(identifier)) {
        //if not already completed, sets the value
        matchingMessage.complete(true);
    } 
}

CompletableFuture<Boolean> isMessageReceivedMatching(String identifier) {
    this.identifier = identifier;
    matchingMessage = new CompletableFuture<>();
    return matchingMessage;
}
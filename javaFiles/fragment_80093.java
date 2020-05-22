@Override
public DeferredResult pull(Long previousId, String username) {


    DeferredResult result = createPollingResult(previousId, username);

    CompletableFuture.runAsync(() -> {
        //this is where you encapsulate your db transaction
        List<MessageDTO> messages = messageService.findRecents(previousId, username); // should be final or effective final
        if (messages.isEmpty()) {
           pollingResults.putIfAbsent(username, result);
        } else {
           result.setResult(messages);
        }
    });

    return result;
}
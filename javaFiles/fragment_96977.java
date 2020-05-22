public CompletableFuture<String> sendEmail(String content, String address) {

    return myService.sendEmail(content, address)
            .thenApply(b -> "good")
            .exceptionally(Throwable::getMessage)
            .thenCompose(status -> myService.saveStatus(status, address));
}
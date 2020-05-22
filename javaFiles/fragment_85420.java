LinkedList<CompletableFuture<Registration>> functions = new LinkedList<>();
functions.add(session.register(prefix + "order_to_produce", this::order_to_produce));

for (CompletableFuture<Registration> function : functions) {
    function.thenAccept(registration -> LOGGER.info("Registered procedure: " + registration.procedure));
}
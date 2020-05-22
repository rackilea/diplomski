final AtomicBoolean hasItems = new AtomicBoolean(false);
stream.forEach(i -> {
    itemConsumer.accept(i);
    hasItems.set(true);
});
if (!hasItems.get()) {
    emptyAction.run();
}
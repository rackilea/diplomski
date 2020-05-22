boolean hasItems = stream.reduce(false, (o, i) -> {
    itemConsumer.accept(i);
    return true;
}, (l, r) -> l | r);
if (!hasItems) {
    emptyAction.run();
}
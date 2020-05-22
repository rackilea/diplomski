class ItemConsumer implements Consumer<Object> {

    private volatile boolean hasConsumedAny;

    @Override
    public void accept(Object o) {
        hasConsumedAny = true;
        //magic magic
    }

    public boolean isHasConsumedAny() {
        return hasConsumedAny;
    }
}

final ItemConsumer itemConsumer = new ItemConsumer();
stream.forEach(itemConsumer::accept);
if (!itemConsumer.isHasConsumedAny()) {
    emptyAction.run();
}
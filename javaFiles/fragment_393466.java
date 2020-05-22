public void subscribe(DataConsumer c) throws IllegalArgumentException {
    Preconditions.checkNotNull(c,
        "Can't subscribe null as a DataConsumer. Object not initialized");
    Preconditions.checkState(dataConsumerList != null,
        "Nothing to subscribe to. DataConsumerList is null");
    dataConsumerList.add(c);
}
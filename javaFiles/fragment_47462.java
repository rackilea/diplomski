@Override
public void initialize(InitializationInput initializationInput) {
    LOGGER.info("Initializing record processor for shard: {}", initializationInput.getShardId());
}

@Override
public void processRecords(ProcessRecordsInput processRecordsInput) {
    List<Record> records = processRecordsInput.getRecords();
    LOGGER.info("Retrieved {} records", records.size());
    records.forEach(r -> LOGGER.info("Record with sequenceId {} at date {} : {}", r.getSequenceNumber(),
            r.getApproximateArrivalTimestamp(), StandardCharsets.UTF_8.decode(r.getData())));
    try {
        processRecordsInput.getCheckpointer().checkpoint();
    } catch (InvalidStateException | ShutdownException e) {
        LOGGER.error("Unable to checkpoint");
    }
}

@Override
public void shutdown(ShutdownInput shutdownInput) {
    LOGGER.info("Shutting down input");
    try {
        shutdownInput.getCheckpointer().checkpoint();
    } catch (InvalidStateException | ShutdownException e) {
        LOGGER.error("Unable to checkpoint");
    }
}
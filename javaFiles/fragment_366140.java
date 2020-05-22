int BULK_ACTIONS_THRESHOLD = 1000;
int BULK_CONCURRENT_REQUESTS = 1;
BulkProcessor bulkProcessor = BulkProcessor.builder(client, new BulkProcessor.Listener() {
    @Override
    public void beforeBulk(long executionId, BulkRequest request) {
        logger.info("Bulk Going to execute new bulk composed of {} actions", request.numberOfActions());
    }

    @Override
    public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
        logger.info("Executed bulk composed of {} actions", request.numberOfActions());
    }

    @Override
    public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
        logger.warn("Error executing bulk", failure);
    }
    }).setBulkActions(BULK_ACTIONS_THRESHOLD).setConcurrentRequests(BULK_CONCURRENT_REQUESTS).setFlushInterval(TimeValue.timeValueMillis(5)).build();
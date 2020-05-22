while (running) {

    List<CloudwatchLogsLogEvent> logEvents = new ArrayList<>();
    eventQueue.drainTo(logEvents);

    printWithTimestamp( "Draining events from eventLoop. No. of events received = " + logEvents.size());

    if(logEvents.size() > 0) {
        printWithTimestamp( "Translating " + logEvents.size() + " log events to CloudWatch Logs...");
        logEvents.stream().forEach(logEvent -> translateLogEventToCloudWatchLog(logEvent));
        printWithTimestamp( "Translating " + logEvents.size() + " log events to CloudWatch Logs... DONE");
    }

    boolean timeToFlush = isTimeToFlush();
    printWithTimestamp( "isTimeToFlush()   = " + timeToFlush);
    printWithTimestamp( "eventBatch.size() = " + eventBatch.size());

    if (!eventBatch.isEmpty() && timeToFlush) {
        printWithTimestamp( "Event Batch is NOT empty and it's time to flush");
        flush();
    }

    try {
        printWithTimestamp( "going to sleep...");
        Thread.sleep(100);
        printWithTimestamp( "done sleeping...");
    } catch (InterruptedException e) {
        printWithTimestamp( "Exception while flushing and sleeping...");
        running = false;
    }
}
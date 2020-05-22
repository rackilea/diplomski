public void checkTimeoutProcessingMessages() {
        for (MyWorker worker : workers) {
            long lastProcessed = worker.getLastProcessedMessageTimestamp();
            long currentTimestamp = System.currentTimeMillis();
            if (lastProcessed + 5000 > currentTimestamp) {
                //warn message
            }
        }
    }
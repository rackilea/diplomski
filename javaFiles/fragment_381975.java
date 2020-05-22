private Object lock = new Object();

public void add(final List<ReportingSTG> message) {
    if(stopRequested.get()) {
        synchronized (this) {
            if(stopRequested.get()) {
                retryQueue.put(message);
            }
        }
    }
    synchronized(lock){
        messages.add(message);
        if(messages.size() >= batchSize && waitingThreads.get() == 0) {
                final List<List<ReportingSTG>> clone = new ArrayList<List<ReportingSTG>>(messages);
                messages.clear();
                if(processors.size()>=numOfProcessors) {
                    waitingThreads.incrementAndGet();
                    waitForProcessor();
                    waitingThreads.decrementAndGet();
                }                   
                startProcessor(clone);
            }
    }
}
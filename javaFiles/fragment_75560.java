private static final int NUM_PROCESSING_QUEUES = 6;
 ...
 ExecutorService[] pools = new ExecutorService[NUM_PROCESSING_QUEUES];
 for (int i = 0; i < pools.length; i++) {
    pools[i] = Executors.newSingleThreadExecutor();
 }
 ...
 // receiver loop:
 while (true) {
    Message message = receiveMessage();
    int hash = Math.abs(message.hashCode());
    // put each message in the appropriate pool based on its hash
    // this assumes message is runnable
    pools[hash % pools.length].submit(message);
 }
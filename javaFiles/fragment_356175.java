BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3); //queue of capacity = 3

Producer p1 = new Producer(queue, 10, 20);
Producer p2 = new Producer(queue, -50, -40);

List<Consumer> consumers = new ArrayList<>();
CompletableFuture[] consumersFutures = new CompletableFuture[3];
for (int i = 0; i < 3; i++) {
    Consumer consumer = new Consumer(queue);
    consumers.add(consumer);
    //this static method runs Runnable in separate thread
    consumersFutures[i] = CompletableFuture.runAsync(consumer);
}

CompletableFuture[] producersFutures = new CompletableFuture[2];

producersFutures[0] = CompletableFuture.runAsync(p1);
producersFutures[1] = CompletableFuture.runAsync(p2);

// allOf returns new CompletableFuture that is completed only 
// when the last given future completes
CompletableFuture.allOf(producersFutures).thenAccept(v -> {
    System.out.println("Completed producing!");
    for (Consumer consumer: consumers) {
        consumer.finish = true;
    }
});

// waiting for all consumers to complete
CompletableFuture.allOf(consumersFutures).get();

System.out.println("Completed consuming!");
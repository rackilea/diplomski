BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

new Thread(() -> {
    try {
        TimeUnit.SECONDS.sleep(1L);
        System.out.println("Producer starts.");
        queue.put("foo");
    } catch (InterruptedException e) { /* NOP */ }
}).start();

try {
    System.out.println("Consumer starts.");
    System.out.println(queue.take());
} catch (InterruptedException e) { /* NOP */ }
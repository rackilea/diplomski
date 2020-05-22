BlockingQueue<Integer> numbers = new ArrayBlockingQueue<>(10);
AtomicBoolean flag = new AtomicBoolean(true);

// Producer.
new Thread(() -> {
    for (int i = 0; i < 10; i++) {
        try {
            numbers.put(i);
        } catch (InterruptedException e) { /* NOP */ }
    }
    flag.set(false);
}).start();

// Consumer.
while (flag.get() || !numbers.isEmpty()) {
    try {
        System.out.println(numbers.take());
    } catch (InterruptedException e) { /* NOP */ }
}
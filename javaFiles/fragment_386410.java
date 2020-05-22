try {
    // Boolean used to know if the counter has been decremented or not
    // It has been moved before the await to avoid doing anything before
    // incrementing/decrementing the counter
    boolean decrementing = (int)(Math.random() * 10) % 2 == 0;
    // Wait until all threads reach this point
    c.await();
    if (decrementing) {
        c.decrement();
    } else {
        c.increment();
    }
    // Print the message
    System.out.format(
        "%s - The internal counter is at %d %s\n", 
        threadName, c.value(), decrementing ? "Decrementing" : "Incrementing"
    );

} catch (Exception e) {
    System.out.format("Thread %s in error\n", threadName);
}
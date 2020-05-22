private static Future<?> producerFuture = null;
public static void main(String[] args) {

    // Remainder omitted.
    producerFuture = producerPool.submit(new ServiceClass(false, false)); 
    // ...
}

private void consume() {
    try {
        // ...
    } catch (Exception e) {
        producerFuture.cancel(true);
    }
}
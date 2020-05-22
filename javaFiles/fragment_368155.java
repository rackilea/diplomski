try {
    while (true) {
        executor.execute(requestQueue.take());
        Thread.sleep(200);
    }
} catch (InterruptedException ex) {...}
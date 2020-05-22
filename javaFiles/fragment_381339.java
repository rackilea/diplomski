synchronized (sharedQueue) {
    while (sharedQueue.isEmpty()) {
        System.out.println("Queue is empty " + Thread.currentThread().getName()
                                + " is waiting , size: " + sharedQueue.size());
        sharedQueue.wait();
    }
}
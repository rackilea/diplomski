protected BlockingQueue<Runnable> createQueue(int queueCapacity) {
    if (queueCapacity > 0) {
        return new LinkedBlockingQueue<Runnable>(queueCapacity);
    }
    else {
        return new SynchronousQueue<Runnable>();
    }
}
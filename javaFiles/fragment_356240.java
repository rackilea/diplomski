@PreDestroy
private void destroyListener() {
    synchronized (this) {
        scheduledTask.cancel(false);
    }
}
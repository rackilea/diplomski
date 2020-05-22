try {
    queue.put(param);
} catch (InterruptedException e) {
    // immediately re-interrupt the thread
    Thread.currentThread().interrupt();
    Log.w(TAG, "put Interrupted", e);
    // maybe we should stop the thread here
}
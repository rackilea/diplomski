final BlockingQueue queue = new ConcurrentBlockingQueue();

private MessageReceivedEvent waitForInput() throws InterruptedException {
    return queue.take();
}

@Override
public void onMessageReceived(MessageReceivedEvent event) {
    queue.put(event);
}
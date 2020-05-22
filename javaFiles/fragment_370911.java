final ReentrantLock lock = new ReentrantLock();
final Condition condition = lock.newCondition();

private void waitForInput() {
    lock.lock();
    Listener.msgEvnt = null;
    try {
        while (Listener.msgEvnt == null)
            condition.await();
    } catch (InterruptedException e) {
        e.printStackTrace();
    } finally {
        lock.unlock();
    }
}

@Override
public void onMessageReceived(MessageReceivedEvent event) {
    lock.lock();
    try {
        Listener.msgEvnt = msgEvnt;
        condition.signal();
    } finally {
        lock.unlock();
    }
}
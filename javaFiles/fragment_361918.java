EventQueue tempEventQueue = new EventQueue();
Toolkit.getDefaultToolkit().getSystemEventQueue().push(tempEventQueue);
try {
    wait();
} catch (InterruptedException ex) {
    // stop waiting on interrupt
} finally {
    tempEventQueue.pop();
}
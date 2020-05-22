lock.lock();
try {
    while (!isFirstGroupRunning) threadGroup2.await();
    // do whatever you need to do in first thread
    isFirstGroupRunning = false;
    threadGroup1.signal();
} finally {
    lock.unlock();
}
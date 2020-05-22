lock.lock();
try {
    while (isFirstGroupRunning) threadGroup1.await();
    // do whatever you need to do in second thread
    isFirstGroupRunning = true;
    threadGroup2.signal();
} finally {
    lock.unlock();
}
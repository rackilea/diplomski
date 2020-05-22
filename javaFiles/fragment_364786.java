try {
    //do something, may take a long time
    Thread.sleep(10);// sleep to simulate a long execution
} finally {
    // Here we notify the main thread that the task is complete whatever
    // the task failed or not
    lock.lock();
    try {
        condition.signal();
    } finally {
        lock.unlock();
    }
}
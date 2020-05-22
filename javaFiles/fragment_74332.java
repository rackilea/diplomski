takeLock.lockInterruptibly();
    try {
            // wait for the queue to stop being empty
            while (count.get() == 0) {
                notEmpty.await();
            }

        // remove element
        x = dequeue();

        // decrement shared count
        c = count.getAndDecrement();

        // send signal that the queue is not empty
        // note that this is logically part of put(), but
        // for thread coordination reasons is here
        if (c > 1)
            notEmpty.signal();
    } finally {
        takeLock.unlock();
    }
    if (c == capacity)
        signalNotFull();
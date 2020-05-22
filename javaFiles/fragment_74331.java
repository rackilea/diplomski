// putLock coordinates the calls to put() only; further coordination
    // between put() and take() follows below
    putLock.lockInterruptibly();
    try {
        // block while the queue is full; count is shared between put() and take()
        // and is safely visible between cores but prone to change between calls
        // a while loop is used because state can change between signals, which is
        // why signals get rechecked and resent.. read on to see more of that 
        while (count.get() == capacity) { 
                notFull.await();
        }

        // we know that the queue is not full so add
        enqueue(e);
        c = count.getAndIncrement();

        // if the queue is not full, send a signal to wake up 
        // any thread that is possibly waiting for the queue to be a little
        // emptier -- note that this is logically part of 'take()' but it
        // has to be here because take() blocks itself
        if (c + 1 < capacity)
            notFull.signal();
    } finally {
        putLock.unlock();
    }
    if (c == 0)
        signalNotEmpty();
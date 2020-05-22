private final Lock myMutex = new ReentrantLock();

public void foobar(...) {
    myMutex.lock();
    try {
        ...
    }
    finally {
        myMutex.unlock();
    }
}

public void bizzwizz(...) {
    myMutex.lock();
    try {
        ...
        foobar(...);
        ...
    }
    finally {
        myMutex.unlock();
    }
}
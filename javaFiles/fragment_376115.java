if(preparedLock.tryLock()) {   // locks the mutex if the result is true.
    preparedLock.lock();       // This locks it A SECOND TIME.
    try{
        ...
    }finally{
        preparedLock.unlock(); // This unlocks it ONCE.
    }
}
// At this point, the thread still has one lock on preparedLock
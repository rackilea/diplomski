while(rand >= 0){
        monitor.critical(threadId);
        rand--;
        N.getAndIncrement();
        if (N.get() == 0) {
            lock.lock();
            try {
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
 }
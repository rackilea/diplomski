AtomicBoolean lock = new AtomicBoolean(false);
    if(lock.compareAndSet(false, true)){
        try {
            //do something
        } catch(Exception e){
            //error handling
        } finally {
            lock.set(false);
        }
    }
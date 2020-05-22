if (next > Byte.MAX_VALUE) {
    synchronized(counter) {
        int i = counter.get(); //here You make sure the the counter is not over the MAX_VALUE
        if (i > Byte.MAX_VALUE) {
            counter.set(INITIAL_VALUE);
            resetCounter.incrementAndGet();
            if (isSlow) slowDownAndLog(10, "resetting");
        } else {
            if (isSlow) slowDownAndLog(1, "missed"); //the counter can reach MAX_VALUE again if you wait here long enough
        }
        next = counter.incrementAndGet(); //here you increment on return the counter that can reach >MAX_VALUE in the meantime
    }
}
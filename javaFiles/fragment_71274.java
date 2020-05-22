public byte nextValue() {
    int next = counter.incrementAndGet();

    if (next > Byte.MAX_VALUE) {
        synchronized(counter) {
            next = counter.incrementAndGet();
            //if value is still larger than max byte value, we reset it
            if (next > Byte.MAX_VALUE) {
                counter.set(INITIAL_VALUE + 1);
                next = INITIAL_VALUE + 1;
                resetCounter.incrementAndGet();
                if (isSlow) slowDownAndLog(10, "resetting");
            } else {
                if (isSlow) slowDownAndLog(1, "missed");
            }
        }
    }

    return (byte) next;
}
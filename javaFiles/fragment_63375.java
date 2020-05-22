/**
     * The hold count of the last thread to successfully acquire
     * readLock. This saves ThreadLocal lookup in the common case
     * where the next thread to release is the last one to
     * acquire.
     * [...]
     */
    private transient HoldCounter cachedHoldCounter;
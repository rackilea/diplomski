Lock lock = ...;
lock.lock();
Throwable primary = null;
try {
    modifySharedState();
} catch (Throwable x) {
    primary = x;
    throw x;
} finally {
    try {
        lock.unlock();
    } catch (Throwable x) {
        if (primary != null) {
            primary.addSuppressed(x);
            // primary is already "in-flight"
            // so no need to throw it again
        } else {
            throw x;
        }
    }
}
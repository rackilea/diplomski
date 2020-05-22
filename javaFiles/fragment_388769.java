public static <T,throws E extends Exception>
T withLock(Lock lock, {=>T throws E} block) throws E {
    lock.lock();
    try {
        return block.invoke();
    } finally {
        lock.unlock();
    }
}
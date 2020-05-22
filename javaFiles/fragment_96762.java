// file name must be:
// path + databaseName + Constants.SUFFIX_LOCK_FILE
static boolean isLocked(String fileName) {
    try {
        FileLock lock = new FileLock(new TraceSystem(null), fileName, 1000);
        lock.lock(FileLock.LOCK_FILE);
        lock.unlock();
        return false;
    } catch (Exception e) {
        return true;
    }
}
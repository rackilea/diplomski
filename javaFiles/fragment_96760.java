static boolean isLocked(String fileName) {
    try {
        RandomAccessFile f = new RandomAccessFile(fileName, "r");
        try {
            FileLock lock = f.getChannel().tryLock(0, Long.MAX_VALUE, true);
            if (lock != null) {
                lock.release();
                return false;
            }
        } finally {
            f.close();
        }
    } catch (IOException e) {
        // ignore
    }
    return true;
}
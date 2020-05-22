private final Map<File, byte[]> cache = new HashMap<File, byte[]>();
private final Map<File, Object> locks = new HashMap<File, Object>();

public byte[] readFile(File file) throws IOException {
    Object lock = getLock(file);
    synchronized (lock) {
        byte[] content = cache.get(file);
        if (content == null) {
            content = Files.readAllBytes(file.toPath());
            cache.put(file, content);
        }
        return content;
    }
}

private synchronized Object getLock(File file) {
    Object lock = locks.get(file);
    if (lock == null) {
        lock = new Object();
        locks.put(file, lock);
    }
    return lock;
}
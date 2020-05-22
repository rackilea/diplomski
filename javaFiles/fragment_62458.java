public class DirectoryTaskManager {
    public static void main(String[] args) throws IOException {
        DirectoryTaskManager manager = new DirectoryTaskManager();
        manager.withDirLock(new File("Folder_A"), () -> System.out.println("Doing something..."));
    }

    public void withDirLock(File dir, Runnable task) throws IOException {
        ReentrantLock lock = getDirLock(dir);
        lock.lock();
        try {
            task.run();
        } finally {
            lock.unlock();
        }
    }

    private Map<File, ReentrantLock> dirLocks = Collections.synchronizedMap(new HashMap<>());

    public ReentrantLock getDirLock(File dir) throws IOException {
        // Resolve the canonical file here so that different paths 
        // to the same file use the same lock
        File canonicalDir = dir.getCanonicalFile();
        if (!canonicalDir.exists() || !canonicalDir.isDirectory()) {
            throw new FileNotFoundException(canonicalDir.getName());
        }
        return dirLocks.computeIfAbsent(canonicalDir, d -> new ReentrantLock());
    }
}
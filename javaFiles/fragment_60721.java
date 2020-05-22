// Create watchers
List<FileWatcher> watchers = new ArrayList<>();
try{
    watchers.add(new FileWatcher(Paths.get("D:")));
    watchers.add(new FileWatcher(Paths.get("E:")));
} catch (AccessDeniedException xx) {
    log.error("AccessDeniedException  ",xx);
} catch (FileSystemException x) {
    log.error("exception",x);
}

// Create and start threads
List<Thread> threads = new ArrayList<>();
for (FileWatcher watcher : watchers) {
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            watcher.processEvents();
        }
    });
    thread.start();
    threads.add(thread);
}
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
List<Thread> threads = watchers.stream()
        .map(w -> new Thread(w::processEvents))
        .peek(Thread::start)
        .collect(Collectors.toList());
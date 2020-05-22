try (WatchService watch = pluginDir.getFileSystem().newWatchService()) {

    pluginDir.register(watch,
        StandardWatchEventKinds.ENTRY_CREATE,
        StandardWatchEventKinds.ENTRY_DELETE,
        StandardWatchEventKinds.ENTRY_MODIFY,
        StandardWatchEventKinds.OVERFLOW);

    WatchKey key;
    while ((key = watch.take()).isValid()) {
        loader.reload();
        key.reset();
    }
}
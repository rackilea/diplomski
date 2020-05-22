Path dir = Paths.get( "/home", "me", "experiments" );
WatchService watcher =  dir.getFileSystem().newWatchService();
dir.register( watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY );
WatchKey key = watcher.take();
for (WatchEvent<?> event: key.pollEvents()) {
    System.out.println( event.kind().name() + " " + event.context() );
}
WatchService watcher = FileSystems.getDefault().newWatchService();

  // Repeat the following code to get a WatchKey for each folder
  try {
    Path dir = FileSystems.getDefault().getPath("logs", "access.log");
    WatchKey key = dir.register(watcher,
                           ENTRY_CREATE,
                           ENTRY_DELETE,
                           ENTRY_MODIFY);
  } 
  catch (IOException x) {
    System.err.println(x);
  }
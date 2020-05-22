// 1 create the watchService
WatchService watchService =    FileSystems.getDefault().newWatchService();

// 2 get a reference to the directory to be watched for changes
String watchedDir = "/mydir";
Path dir = Paths.get(watchedDir);

// 3 register on the events you need to watch
WatchKey watchKey = dir.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

...

// 4 wait for changes, generally inside a loop
watchKey = watchService.take();
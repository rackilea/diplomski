Path path = Paths.get("C:\\Temp");

// Watch for files and directories being created in C:\\Temp
// (also triggers when file is renamed)
WatchService watchService = FileSystems.getDefault().newWatchService();
WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

// Wait until an event happens
WatchKey key = watchService.take();

// Look at the events that were signaled on the key
for (WatchEvent<?> event : key.pollEvents()) {
    System.out.println(event.kind() + " " + event.context());
}

// Stop receiving events
key.cancel();
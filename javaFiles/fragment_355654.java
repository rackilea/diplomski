Set<Thread> threadsBefore = Thread.getAllStackTraces().keySet();
WatchService ws = FileSystems.getDefault().newWatchService();

//I don't need to wait here on my machine but YMMV

Set<Thread> threadsAfter = Thread.getAllStackTraces().keySet();
threadsAfter.removeAll(threadsBefore);
Thread wsThread = threadsAfter.toArray(new Thread[1])[0];

System.out.println("wsThread = " + wsThread);

wsThread.setName("WatchService Thread");

Set<Thread> justChecking = Thread.getAllStackTraces().keySet();
System.out.println("justChecking = " + justChecking);
ConcurrentMap<FileStore, Semaphore> map = new ConcurrentHashMap<>();
ExecutorService es = Executors.newFixedThreadPool(10);
for (Path path : listFile()) {
  final FileStore store = Files.getFileStore(path);
  final Semaphore semaphore = map.computeIfAbsent(store, key -> new Semaphore(getAllocatedCredits(store)));
  final int cost = computeCost(path);
  es.submit(() -> {
    semaphore.acquire(cost);
    try {
      ... some work ...
    } finally {
      semaphore.release(cost);
    }
  });
}


int getAllocatedCredits(FileStore store) {return 2;}
int computeCost(Path path) {return 1;}
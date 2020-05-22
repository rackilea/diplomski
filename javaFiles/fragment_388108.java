//We use atomicInteger because the Runnable will be in other thread
AtomicInteger currentIteration = new AtomicInteger(0);

int maxAttempts = 100;

Map<String, Integer> idToProcessIdMap = new HashMap<>();
final String customProcessId = UUID.randomUUID().toString();

Consumer<String> endProcessConsumer = ((generatedId) -> {
  int processId = idToProcessIdMap.get(generatedId);
  Bukkit.getScheduler().cancelTask(processId);
});

int taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
  public void run() {

    Random rand = new Random();
    int rnum = rand.nextInt(main.allowed.size()) + 1;

    e.getPlayer().getInventory().addItem(main.allowed.get(rnum));

    for(int i = 0; i >= main.getConfig().getInt("SpawnerCase.HowManySpawners"); i++) {
      // Something here.
    }

    int currentIt = currentIteration.incrementAndGet();
    if(currentIt > maxAttempts){
      endProcessConsumer.accept(customProcessId);
    }
  }
}, 0L, 0L);

idToProcessIdMap.put(customProcessId, taskId);
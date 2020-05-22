AtomicInteger currentIteration = new AtomicInteger(0);
int maxAttempts = 100;

AtomicInteger processId = new AtomicInteger();

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
      Bukkit.getScheduler().cancelTask(processId.get());
    }
  }
}, 0L, 0L);

processId.set(taskId);
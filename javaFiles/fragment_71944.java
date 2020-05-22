public class PokeableService {

  private ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
  private final Runnable codeToRun;

  public PokeableService (Runnable toRun, long delay, long interval, TimeUnit units) {
    codeToRun = toRun;
    service.scheduleAtFixedRate(toRun, delay, interval, units);
  }

  public void poke () {
    service.execute(codeToRun);
  }
}
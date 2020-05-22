public class ServiceInitializer extends ExternalResource {
  public static final TestRule INSTANCE = new ServiceInitializer();
  private final AtomicBoolean started = new AtomicBoolean();

  @Override protected void before() throws Throwable {
    if (!started.compareAndSet(false, true)) {
      return;
    }
    // Initialization code goes here
  }

  @Override protected void after() {
  }
}
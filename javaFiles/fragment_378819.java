@Singleton
public class BackgroundTasks {

  @Inject
  public BackgroundTasks(ApplicationLifecycle lifecycle) {
    lifecycle.addStopHook(() -> {
      Logger.info("Stopping background tasks");
      this.shutdown();

      Logger.info("Saving modules data");
      for(Module m: controllers.Application.modules){
        m.saveData();
      }
      return F.Promise.pure(null);
    });
  }
}
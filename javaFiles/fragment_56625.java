public class NotifWorker extends Worker {

  @Inject
  ToBeInjectedClass toBeInjectedClass;

  public NotifWorker() {
    YourApplicationClass
        .getInstance()
        .getAppComponent()
        .inject(this)
  }
}
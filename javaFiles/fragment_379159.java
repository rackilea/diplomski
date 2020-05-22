public class ServerEventHandler extends UntypedActor {
  @Override
  public void onReceive(final Object message) {
    System.out.println("Got event in thread: " + Thread.currentThread().getName());
    System.out.println("Event: " + message);
  }
}
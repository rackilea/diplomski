abstract class NotificationService implements Callable<Object>{
  // ...

  // I don't know what types conn and param2 are, so ...
  protected abstract void process( ConnType conn, Param2Type param2 );

  @Override
  public Object call(){
      try {
              process(conn, param2); // Passing connection & obj
      } catch (Exception e) {
              throw e;
      }
      return null;
  }
}
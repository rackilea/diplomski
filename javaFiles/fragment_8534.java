public class MyContext{
  private static final
  ThreadLocal<Connection> connection = new ThreadLocal<Connection>();

  public static void enter() {
     connection.set(initializeConnection());
     // this is eager initialization
     // if you think it will often the case that no connection is actually
     // required inside a context, you can defer the actual initialization
     // until the first call to get()
  }

  public static void exit() {
    try { connection.close(); }
    catch(Throwable t) { /* panic! */ }
    finally { connection.set(null); }
  }

  public static Connection get() {
    Connection c = connection.get();
    if (c == null) throw new IllegalStateException("blah blah");
    return c;
  }
}
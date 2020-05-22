public class MySingleton {

  public static MySingleton getInstance(Context context) {
    if (instance==null) {
      // Make sure you don't leak an activity by always using the application
      // context for singletons
      instance = new MySingleton(context.getApplicationContext());
    }
    return instance;
  }

  private static MySingleton instance = null;

  private MySingleton(Context context) {
    // init your stuff here...
  }

  private String id = null;
  private String uniqueId= null;
  private String token = null;
  private String sessionId = null;
}
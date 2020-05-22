public class YourApp extends Application {
   private static YourApp sInstance;
   public YourApp() {
      super();
      sInstance = this;
   }
   public static YourApp getInstance() {
      return sInstance;
   }
}
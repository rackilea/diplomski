public class App {
   private static App instance = null;
   public ArrayList<Object> accessibleArray;
   protected App() {
        accessibleArray = new ArrayList<Object>();
   }
   public static App getInstance() {
      if(instance == null) {
         instance = new App();
      }
      return instance;
   }
}
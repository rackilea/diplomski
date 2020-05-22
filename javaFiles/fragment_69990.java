public class MyConnectionClass {
   private static final MyConnectionClass SINGLE_INSTANCE = new MyConnectionClass();

   private MyConnectionClass() {}

   public static MyConnectionClass getInstance() {
      return SINGLE_INSTANCE;
   }
 }
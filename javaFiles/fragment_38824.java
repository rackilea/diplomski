public class MyFrame extends JFrame {
   private static MyFrame instance = null;
   private MyFrame() {
      // Private to prevent instantiation.
   }

   public static MyFrame getInstance() {
      if(instance == null) {
         instance = new MyFrame();
      }
      return instance;
   }
}
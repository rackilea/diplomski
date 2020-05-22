public class SomeClassImpl implements SomeClass {
   private static final SomeLib someLib;
   static {
     SomeLib tmp = null;
     try {
       tmp = new SomeLib();
     } catch (UnknownHostException uhe) {
       // Handle exception.
     }
     someLib = tmp;
   }
}
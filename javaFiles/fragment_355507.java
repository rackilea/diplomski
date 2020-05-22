public class TestWrapper {
/* args[0] - class to launch. Remainder of args passed to launched app.*/
   public static void main(String[] args) throws Exception
   {
      Class app = Class.forName(args[0]);
      Method main = app.getDeclaredMethod("main", new Class[] { (new String[1]).getClass()});
      String[] appArgs = new String[args.length-1];
      System.arraycopy(args, 1, appArgs, 0, appArgs.length);
      main.invoke(null, appArgs);
      // now you have just launched another application inside the same VM
   }
public class AppWrapper
{
/* args[0] - class to launch */     
   public static void main(String[] args) throws Exception
   {  // error checking omitted for brevity
      Class app = Class.forName(args[0]);
      Method main = app.getDeclaredMethod("main", new Class[] { (new String[1]).getClass()});
      String[] appArgs = new String[args.length-1];
      System.arraycopy(args, 1, appArgs, 0, appArgs.length);
      System.setProperty("http.proxyHost", "someHost");
      main.invoke(null, appArgs);
   }
}
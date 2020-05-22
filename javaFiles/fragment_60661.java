import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App
{
   private static final Logger logger = LogManager.getLogger(App.class.getName());

   public static void main(String[] args)
   {
      logger.info("test");
      System.out.println( "Hello World!" );
      logger.warn("Dummy warning");
   }
}
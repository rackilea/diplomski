import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
public class MyLogger { 
   static {   System.setProperty("log4j.configurationFile",System.getProperty("prop.loc")+File.separator+"MyLog4j2.xml");   
   }

   public static Logger getLogger(Class<?> clazz){
         return LogManager.getLogger(clazz);
   }
}
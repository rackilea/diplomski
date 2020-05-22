public class SharedFolderEndpoint extends Endpoint {
   private static final String BASEDIR_FORMAT = "/env-%s/somefolder/files";
   //...


   // might need to declare this as throwing the exception
   public String getBaseDir() {  
      if (environment.isPopulated()) {
        return String.format(BASEDIR_FORMAT, environment.toString());
      } else {
        // throw an exception...
      }
   }
}
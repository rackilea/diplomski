public class SharedFolderEndpoint extends Endpoint {
   private static final String BASEDIR_FORMAT = "/env-%s/%s/%s";
   //...


   // might need to declare this as throwing the exception
   public String getBaseDir() {  
      if (!environment.isPopulated()) {
        // ... throw exception showing no environment
      } else {
      if (!folder.isPopulated()) {
        // ... throw exception showing no folder
      } else {
      if (!file.isPopulated()) {
        // ... throw exception showing no file
      } else {
        // throw an exception...
        return String.format(BASEDIR_FORMAT, 
               environment.getText(),
               folder.getText(),
               files.getText());
      }
   }
}
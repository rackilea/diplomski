public class FileHandler extends StreamHandler {

   private String pattern;

   private void configure() {

        String cname = getClass().getName();
        pattern = manager.getStringProperty(cname + ".pattern", "%h/java%u.log");
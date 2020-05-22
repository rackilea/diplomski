@Component
public class FileWriter implements LogWriter {
   public void write(String text) {
      System.out.println("FileWriter: " + text);
   }
}
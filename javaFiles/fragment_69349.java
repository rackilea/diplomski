import java.io.FileInputStream;
import java.util.Properties;

public class MainClass {
  public static void main(String args[]) throws IOException {
    Properties p = new Properties();
    p.load(new FileInputStream("foo.properties"));
    Object label = p.get("page.label");
    System.out.println(label);
  }
}
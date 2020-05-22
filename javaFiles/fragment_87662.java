import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Play {
  public static void main(String args[]) { 
    Properties props = new Properties();
    Path path = Paths.get(System.getProperty("java.home"), "lib", "net.properties");

    try (Reader r = Files.newBufferedReader(path)) {
      props.load(r);
      System.out.println("props loaded!");
    } catch (IOException x) {
      System.err.println("props failed loading!");
      x.printStackTrace(System.err);
    }
    // Now you have access to all the net.properties!
    System.out.println(props.getProperty("http.proxyHost"));
 }
}
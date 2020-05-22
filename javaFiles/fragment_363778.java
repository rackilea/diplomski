import java.net.MalformedURLException;
import java.net.URL;

public class URLExample {
  public static void main(String[] args) throws MalformedURLException {
    printURLInformation(new URL("https://www.somesite.com/?param1=val1"));
    printURLInformation(new URL("https://www.somesite.com?param1=val1"));
  }

  private static void printURLInformation(URL url) {
    System.out.println(url);
    System.out.println("Path:\t" + url.getPath());
    System.out.println("File:\t" + url.getFile());
    System.out.println("Query:\t" + url.getQuery() + "\n");
  }

}
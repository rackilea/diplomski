import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

public class Play {
  public static void main(String args[]) { 
    System.out.println(System.getProperty("java.home"));
    System.out.println(System.getProperty("http.proxyHost"));
    ProxySelector ps = ProxySelector.getDefault();
    List<Proxy> proxies = ps.select(URI.create("http://www.yahoo.com"));
    System.out.println("HTTP Proxies");
    for (Proxy p:proxies) {
      System.out.append(p.toString()).append("\n");
    }
 }
}
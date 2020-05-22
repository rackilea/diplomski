import java.io.File;
import java.net.MalformedURLException;
import java.util.Date;

import com.redfin.sitemapgenerator.ChangeFreq;
import com.redfin.sitemapgenerator.WebSitemapGenerator;
import com.redfin.sitemapgenerator.WebSitemapUrl;

public class SitemapGenerator {

  public static void main(String[] args) throws MalformedURLException {

    WebSitemapGenerator webSitemapGenerator = WebSitemapGenerator.builder("http://www.example.com", new File("C:\\sitemap"))
    .gzip(true).build();

    WebSitemapUrl webSitemapUrl = new WebSitemapUrl.Options("http://www.example.com/test1.html")
      .lastMod(new Date()).priority(1.0).changeFreq(ChangeFreq.HOURLY).build();

    webSitemapGenerator.addUrl(webSitemapUrl);
    webSitemapGenerator.addUrl("http://www.example.com/test2.html");
    webSitemapGenerator.write();
  }
}